package com.app.service.module.calculate.service

import com.app.service.module.calculate.common.BaseService


trait SparkService extends BaseService {

  /**
    * 词频统计
    *
    * @param wordList
    * @return
    */
  def wordCount(wordList: List[String]): scala.collection.Map[String, Long]

}

