# Astrology-Application

🌑 :new_moon:	🌒 :waxing_crescent_moon:	🌓 :first_quarter_moon:
🌔 :waxing_gibbous_moon:	🌕 :full_moon:	🌖 :waning_gibbous_moon:
🌗 :last_quarter_moon:	🌘 :waning_crescent_moon:	

## Technology Used

- API using Spring Boot in Java
- Database Connectivity using MongoDB Docker Image

## Use-Case
For the more curious Astrologers who reference full natal and synastry charts, 
but are not yet fluent in all planetary aspects, google is your best friend.
However, when googling Astrological aspects, the majority of information is limited to 2 planets at most. 
Therefore, all astrolgers have to infer the information from a limited perspective.
This does not affect experienced astrolgers, but provides a barrier to entry for beginner/intermediate astrologers.

## How this API will help

- Working towards developing an API that can provide more detailed aspects than currently available from the main Astrological websites
- Eventually develop a client side phone application for easy access to the API  :iphone: 

## Current method used for researching Astrological Aspects VS The API

#### Googling Moon in Pisces in the 11th House 

1. Google what moon means
2. Google what Pisces means
3. Google what Moon In Pisces means for a clear understanding of their synastry
4. Google how the Moon reacts in the 11th House
5. Google how Pisces reacts in the 11th House
6. Attempt to blend all this confusing information together

#### Proposed Use Case for this API

1. Tap the planet (Moon)
2. Tap the sign (Pisces)
3. Tap the house (11th)
4. Read appropriately returned data (Easy :relaxed:)

## The Code

### Anotations Used

### Controller
* The controller class handles the end points that will be queryed. 
* Below shows a @GetMapping annotation which returns all Signs.
* Complexity of the method which returns the data is abstracted by the Service.
```java
@RestController
@RequestMapping("/signs")
public class SignController {
    private SignService signService;
    public SignController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/all")
    public List<Sign> getAll() {
        return this.signService.getAll();
    }
```


### Model
* The folder POJO consits of 5 Astrological Objects: Astral, Sign, House, Element, Mode.
* A Custom POJO called AstroSearch is used to return a full custom search to the endpoint.
```java
@Getter
@Setter
@Document(collection = "Signs")
public class Sign {
    @Id
    private String zodiac;
    private String element;
    private String mode;
    private int house;
    private String attributes;
```


### Repository
* This Interface provides the MongoDB Connectivity inside the project.
* All Classes apart from House take two parameters: the Object and the Id.
* The complexity of the database allows for all @Id's in POJO's to be named their normal attributes.
* Querying MongoDB requires the Interface methods naming conventions to match how you will query mongoDb's database as stated in the documentation: https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
```java
@Repository
public interface SignRepository extends MongoRepository<Sign, String> {
    List<Sign> findByElement(String element);
    List<Mode> findByMode(String mode);
    Sign findSignByHouse(int house);
}
```

### Service
* The service handles and abstracts all complexity.
* Now controllers can simply instantiate an object of the service required and return the method to match the endpoint.
```java
@Getter
@Setter
@Service
public class SignService {

    private Sign sign;
    private SignRepository signRepository;

    public SignService(SignRepository signRepository) {
        this.signRepository = signRepository;
    }

    public List<Sign> getAll() {
        return this.signRepository.findAll();
    }
```

### JSON
```json
 {
    "zodiac": "Aries",
    "element": "Fire",
    "mode": "Cardinal",
    "house": 1,
    "attributes": "Aries is the first sign of the zodiac, and Aries natives are the first to start—and the first to finish—whatever they set out to do. Aries is an active, energetic sign. People with Sun in Aries are direct, straightforward, and uncomplicated. They expect the same from others, and are baffled when they don’t always get it.\n\nThe body comes first with Aries. Sun in Aries people are natural athletes. At the very least, their natural inclination is to use their bodies to get things done. They’re not given to long, drawn-out emotional moments; nor are they big on planning ahead. Instead, they live their lives simply. What is happening right now is most important to Aries. Impatience is a definite vice, and innovation is a huge strength. Aries loves to start anything new, and they have trouble sitting still. They are pioneers in whatever they do, and there is a very basic quality of bravery in these people that is unmistakable! Aries generally knows what they want, and they know the quickest route to getting it. They take shortcuts if they must, but generally, everything is aboveboard. Underhanded just isn’t their style. Some Aries people are bold, but even the quieter ones are brave and even plucky in their own way. Independence is their birthright. Nothing gets them going more than a fresh slate, the promise of a new day, and a brand new start.\n\nAries enjoys a challenge, and Aries Suns are happiest when their lives are moving forward and active. There’s a childlike quality to all Aries Sun people, and it’s often quite charming."
  }
```

### MongoDB
* MongoDB has 5 collections inside the database instead of 1.
* Sepurating the collections makes returning custom search reults much easier and provides clearer abstraction when scaling this API.
* An example of why custom search results require different collections can be seen below
![image](https://user-images.githubusercontent.com/63508057/106437609-59753b00-646d-11eb-912b-9a2c6b694f7f.png)


### Custom Search Results
* This code demonstrates the Class and one method of the custom search controller
* For a front end client application to benefit from the database as intended, all varients need to be available.
* In this exmaple, the endpoint takes multiple endpoints through the @GetMapping Annotation.
* All Objects use the already built services to return appropriate data.
* This method returns any combination of data from all five collections.
* The current data in this astrology app is about 30% of the total content. Once Aspects are introduced, the custom search results will become heavy handed and will require alot more abstracted data in different collections to manage and scale effectively.
```java
@RestController
@RequestMapping("/custom")
public class CustomController {

    private AstralBodyService astralBodyService;
    private SignService signService;
    private ElementService elementService;
    private HouseService houseService;
    private ModeService modeService;

    public CustomController(AstralBodyService astralBodyService, SignService signService, ElementService elementService, HouseService houseService, ModeService modeService) {
        this.astralBodyService = astralBodyService;
        this.signService = signService;
        this.elementService = elementService;
        this.houseService = houseService;
        this.modeService = modeService;
    }
    
    @GetMapping("/search/{astral}/{sign}/{house}/{element}/{mode}")
    public AstroSearch customSearch(
            @PathVariable("astral") String astral,
            @PathVariable("sign") String sign,
            @PathVariable("house") int house,
            @PathVariable("element") String element,
            @PathVariable("mode") String mode) {
        return new AstroSearch(
                astralBodyService.getAstralBodyById(astral),
                signService.getSignByZodiac(sign),
                houseService.getHouseByName(house),
                elementService.getElementById(element),
                modeService.getModeById(mode));
    }

}

```

### Future Additions

#### Custom Controller
* More functionality to the custom search results

#### Aspects
* All Astral Squares, Oppositions and Trines.
* All Astral Conjunctions.
* Astral Body in all Houses Attributes
* Signs in all Houses Attributes
* Combinations of Astral Body, House and Sign Attributes
