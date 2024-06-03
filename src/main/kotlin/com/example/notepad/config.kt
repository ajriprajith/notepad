import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory


@Configuration
class Config {

    @Bean
    fun mongoTemplate(): MongoTemplate {
        val factory = SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/notedb")
        return MongoTemplate(factory)
    }

}
