package com.app.service.module.calculate.service.impl


import com.app.service.module.calculate.service.SparkService
import org.springframework.stereotype.Service

@Service
class SparkServiceImpl extends SparkService {

  override def wordCount(wordList: List[String]): scala.collection.Map[String, Long] = {
    val words = sparkContext.parallelize(wordList)
    val wordCounts = words.countByValue
    wordCounts
  }

}
