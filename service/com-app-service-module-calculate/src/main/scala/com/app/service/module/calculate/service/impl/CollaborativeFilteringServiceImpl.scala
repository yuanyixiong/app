package com.app.service.module.calculate.service.impl

import java.io.File
import java.util.Objects

import com.app.service.module.calculate.service.CollaborativeFilteringService
import org.springframework.stereotype.Service

import scala.collection.mutable
import scala.io.Source

@Service
class CollaborativeFilteringServiceImpl extends CollaborativeFilteringService {

  override def doTask_01(filrUrl: String): Unit = {
    //获取当前工程跟路径
    val file = Objects.requireNonNull(classOf[CollaborativeFilteringServiceImpl].getClassLoader.getResource("")).getFile
    val url = new File(file).getParentFile.getParent
    print(url + File.separator + filrUrl)
    val source = Source.fromFile(url + File.separator + "src/main/data" + File.separator + filrUrl, "UTF-8");
    //print(source.getLines().toArray.length)

    val emptyMap = new mutable.HashMap[String, mutable.HashMap[String, String]]()

    source.getLines().foreach(line => {
      val row = line.split(",")
      val user_id = row(0)
      val item_id = row(1)
      val rating = row(2)
      val timestamp = row(3)
      if (emptyMap.get(user_id) == null) {
        val map = new mutable.HashMap[String, String]
        emptyMap.put(user_id, new mutable.HashMap[String, String]);
      }
    })


  }

}
