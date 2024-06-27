package com.example.demo.repositories

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.example.demo.models.NoteModel
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.stereotype.Repository



class NoteCustomRepositoryImpl(
    private val mongoTemplate: MongoTemplate) : NoteCustmRepository {

    private val logger: Logger = LoggerFactory.getLogger(NoteCustomRepositoryImpl::class.java)
    override fun findNotesByTitle(title: String): List<NoteModel?> {
            logger.info("start with aggregation")
            val matchOperation = Aggregation.match(Criteria.where("title").regex(title, "i"))
            val aggregation = Aggregation.newAggregation(matchOperation)
            val aggregationResults = mongoTemplate.aggregate(aggregation, "Notepad", NoteModel::class.java)
            logger.info("done with aggregation")
            return aggregationResults.mappedResults
    }
}
