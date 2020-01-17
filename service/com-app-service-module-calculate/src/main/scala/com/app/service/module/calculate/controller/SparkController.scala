package com.app.service.module.calculate.controller

import com.app.service.module.calculate.service.SparkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array("/spark"))
class SparkController {

  @Autowired
  private var sparkService: SparkService = _

  @RequestMapping(method = Array(RequestMethod.POST), path = Array("/word/count"))
  def wordCount(@RequestParam words: String): java.util.Map[String, Long] = {
    val list = words.split("").toList
    import scala.collection.JavaConversions._
    sparkService.wordCount(list)
  }
}