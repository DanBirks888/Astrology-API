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
  },
  {
    "zodiac": "Taurus",
    "element": "Earth",
    "mode": "Fixed",
    "house": 2,
    "attributes": "There is something very solid about Taurus natives, no matter what the rest of their charts say about them. Though they are dependable most of the time, this generally shows itself more in habit than in outright helpfulness.\n\nTaurus natives are sensual folk–and this includes sex, but extends to pleasures in all areas: they delight in the sensual pleasures of food, a comfortable blanket, a richly colored aquarium to look at, the smell of flowers or spring rain, pleasing melodies coming from their stereos, and so forth. Some might even say they live through their senses more than most.\n\nWhen Taurus natives work, they work hard. They do it with a steadiness that may rarely be considered quick–rather it’s a dependable, plodding, and steady effort that has its payoffs. Security is immensely important to Taurus–some of them actively seek wealth, while others are content to be “comfortable”. The Taurus attributes of “comfortable” may not be exactly the same as the rest of the signs, but comfort is definitely a driving force.\n\nAlthough hard-working, their fixed and comfort-loving nature sometimes makes them appear lazy. This is only because they separate work and leisure so well. When they work, they work hard, and when they play, they don’t really “play” as such…they relax. A Solar Taurus who has kicked his or her feet up is rooted there–you’d be hard-pressed to get them to move. On a mental level, you’ll likely have the same problem. Taureans stick with things and ideas, and therein lies one of the reasons why they are known for their stubbornness. Taurus is a fixed sign, and they have a fair measure of tradition and steadiness in their make-up that keeps them rooted.\n\nThe possessiveness associated with Taurus shows up in all areas of life in some way. Taurus likes to own things (and sometimes people). A nice home, a piece of land (this can be modest), a paid-off car, that aquarium mentioned earlier, a couple pets, maybe a solid business…In love and relationship, there is an earthy kind of possessiveness that may be considered jealousy by some, but there is actually quite a difference between being possessive and being jealous. Taurus natives are rarely jealous and petty. They do, however, think of the people they love as theirs–it adds to their sense of security."
  },

```
