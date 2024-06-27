import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    fun mongoDatabase(): MongoDatabase {
        val connectionString = "mongodb+srv://root:root@democluster.2b62pv0.mongodb.net/?retryWrites=true&w=majority&appName=democluster"
        val settings = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(connectionString))
            .build()
        val mongoClient = MongoClients.create(settings)
        return mongoClient.getDatabase("democluster")
    }
}