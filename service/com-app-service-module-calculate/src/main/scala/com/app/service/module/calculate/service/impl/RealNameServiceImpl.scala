package com.app.service.module.calculate.service.impl


import com.app.service.module.calculate.service.RealNameService
import org.springframework.stereotype.Service

@Service
class RealNameServiceImpl extends RealNameService {

  override def doTask_01(): Unit = {
    val orders_df = sparkSql.sql("select * from yinian_app_user.user_auth_info limit 10")
    orders_df.show(10)
  }

  override def doTask_02(): Unit = {
    val cont = sparkContext.textFile("hdfs://47.106.131.254:9000/user/hadoop/flume/lktest/test1")
//      .map(_.split(","))
      .count()
    print(cont)
  }

  override def doTask_03(): Unit = {
//    import org.apache.spark.sql.SparkSession
//
//
//    case class FlumeData(id: String, cellphone: String, userId: String, contactCellphone: String, contactName: String)
//
//    //
//    def stringReplace(string: String): String = {
//      string.replace("\"", "")
//    }
//
//    val spark = SparkSession.builder
//      .master("local")
//      .appName("Java Spark SQL basic example")
//      .config("spark.some.config.option", "some-value")
//      .getOrCreate
//
//    // 引入架包
//    import spark.implicits._
//
//    println("scala is begin ......")
//
//    val peopleDF = spark.sparkContext
//      .textFile("hdfs://emr-header-1.cluster-115354:9000/user/hadoop/flume/lktest/test1")
//      .map(_.split(","))
//      .map(data => FlumeData(stringReplace(data(0)), stringReplace(data(1)), stringReplace(data(2))
//        , stringReplace(data(3)), stringReplace(data(4)))).toDF()
//
//    // Register the DataFrame as a temporary view
//    peopleDF.createOrReplaceTempView("people")
//
//
//    val fastName: String = "王,李,张,刘,陈,杨,黄,吴,赵,周,徐,孙,马,朱,胡,林,郭,何,高,罗,郑,梁,谢,宋,唐,许,邓,冯,韩,曹,曾,彭,肖,蔡,潘,田,董,袁,于,余,蒋," + "叶,杜,苏,魏,程,吕,丁,沈,任,姚,卢,钟,姜,崔,谭,廖,范,汪,陆,金,石,戴,贾,韦,夏,邱,方,侯,邹,熊,孟,秦,白,江,闫,薛,尹,付,段,雷,黎,史,龙,贺,陶,顾,龚,郝," + "毛,邵,万,钱,严,洪,赖,武,傅,莫,孔,汤,向,常,温,康,施,文,牛,樊,葛,邢,安,齐,易,乔,伍,庞,颜,倪,庄,聂,章,鲁,岳,翟,申,殷,詹,占,欧,耿,关,兰,焦,俞,左,柳," + "甘,祝,包,宁,符,阮,尚,舒,纪,柯,梅,童,毕,凌,单,季,成,霍,苗,裴,涂,谷,曲,盛,冉,翁,蓝,骆,路,游,靳,辛,欧阳,管,柴,蒙,鲍,华,喻,祁,房,蒲,滕,萧,屈,饶,解,牟" + ",艾,尤,时,阳,穆,农,司,古,吉,卓,车,简,连,芦,缪,项,麦,褚,窦,娄,戚,岑,党,宫,景,卜,费,冷,晏,覃,卫,习,席,柏,米,宗,代,桂,瞿,全,苟,闵,佟,应,臧,边,卞,姬," + "邬,和,师,仇,候,栾,隋,刁,沙,商,寇,荣,巫,郎,桑,丛,阎,甄,敖,虞,仲,池,巩,明,佘,查,麻,苑,迟,邝,封,官,谈,鞠,匡,惠,荆,乐,冀,胥,郁,南,班,储,原,栗,燕,楚" + ",鄢,劳,谌,奚,皮,蔺,楼,粟,冼,盘,满,闻,位,厉,伊,仝,区,郜,海,阚,花,权,强,帅,屠,豆,朴,盖,练,廉,禹,井,巴,漆,祖,丰,支,卿,国,狄,平,计,索,宣,晋,相,初,门" + ",云,容,敬,来,扈,晁,都,芮,普,阙,戈,浦,伏,薄,鹿,邸,雍,辜,阿,羊,母,乌,亓,裘,修,邰,杭,赫,况,那,宿,鲜,逯,印,隆,茹,诸,战,慕,危,玉,银,亢,公,嵇,哈,湛,宾" + ",勾,茅,戎,利,扬,於,呼,居,干,揭,但,尉,斯,元,束,檀,衣,信,阴,展,昝,智,幸,奉,植,富,衡,尧,由,哀,爱,昂,熬,傲,奥,把,百,摆,拜,邦,宝,保,暴,北,贝,贲,本,闭" + ",碧,薜,别,邴,伯,博,补,布,步,部,才,采,彩,菜,仓,苍,藏,操,曽,茶,产,昌,苌,畅,倡,唱,钞,超,巢,朝,潮,沉,晨,呈,承,赤,敕,崇,瘳,丑,除,楮,揣,传,春,淳,啜,慈" + ",次,从,催,翠,寸,达,笪,答,丹,旦,淡,刀,道,德,迪,底,第,佃,定,东,冬,懂,钭,堵,端,敦,顿,多,朵,鄂,恩,尔,佴,法,番,藩,凡,芳,飞,斐,风,酆,逢,凤,俸,扶,苻,洑" + ",浮,福,甫,府,复,淦,刚,皋,杲,格,庚,弓,恭,拱,贡,供,缑,菇,贯,冠,光,广,归,贵,呙,虢,果,过,还,寒,汉,行,蒿,好,昊,浩,禾,合,河,荷,黑,恒,弘,红,宏,鸿,后,厚" + ",忽,湖,虎,户,滑,化,怀,淮,槐,环,桓,宦,皇,辉,回,会,火,伙,基,稽,及,汲,戢,籍,记,继,暨,加,佳,家,嘉,郏,荚,甲,菅,翦,蹇,见,建,剑,将,降,娇,矫,徼,缴,教,接" + ",节,杰,颉,介,京,经,靖,静,酒,咎,琚,菊,巨,句,具,俱,剧,矍,军,君,俊,卡,开,凯,勘,堪,考,科,可,克,空,库,蒯,郐,旷,奎,蒉,阔,喇,稂,朗,勒,蕾,类,梨,礼,里,理" + ",力,历,立,丽,励,郦,莲,良,粱,疗,寥,列,吝,泠,零,另,令,留,庐,炉,禄,伦,洛,雒,闾,侣,律,绿,买,曼,茆,卯,冒,么,枚,美,梦,弥,糜,弭,宓,秘,密,妙,闽,敏,名,谬" + ",磨,墨,默,木,沐,牧,睦,纳,娜,乃,铙,能,尼,年,念,乜,钮,鸥,偶,攀,泮,逄,朋,蓬,澎,骈,濮,溥,柒,其,奇,祈,耆,綦,千,乾,潜,羌,谯,郄,钦,琴,勤,青,清,庆,丘,秋" + ",求,渠,璩,却,荛,绕,仁,日,融,如,汝,瑞,闰,润,若,撒,萨,赛,伞,森,厦,山,闪,陕,善,赏,上,韶,卲,绍,厍,莘,神,甚,慎,升,生,绳,圣,诗,拾,矢,士,世,侍,是,释,守" + ",首,寿,殳,书,疏,树,双,水,税,顺,思,松,送,素,眭,睢,随,所,锁,塔,台,太,泰,郯,潭,塘,桃,淘,腾,藤,提,遆,天,帖,铁,通,同,徒,脱,陀,庹,拓,完,宛,旺,望,威,巍," + "伟,隗,未,蔚,问,瓮,沃,无,毋,吾,仵,兀,西,希,郗,息,溪,袭,洗,喜,霞,仙,先,贤,咸,线,香,湘,象,宵,箫,潇,晓,孝,校,忻,星,刑,兴,雄,吁,须,顼,绪,续,轩,禤,玄," + "学,雪,寻,郇,荀,牙,雅,焉,延,言,岩,彦,艳,宴,洋,仰,养,样,幺,侥,药,要,冶,野,业,依,仪,夷,怡,宜,乙,蚁,弋,义,奕,羿,益,裔,翼,英,盈,营,永,勇,犹,油,友,有," + "迂,鱼,宇,羽,庾,遇,誉,毓,员,源,远,院,月,悦,越,允,运,恽,载,宰,迮,增,甑,粘,斩,长,仉,掌,钊,招,兆,肇,折,真,阵,镇,征,正,政,只,职,郅,治,中,忠,衷,种,皱," + "邾,珠,竹,竺,主,壮,禚,资,子,紫,訾,自,字,纵,俎,佐"
//
//    val res = spark.sql("select cellphone,contactName,count(contactName) as cnt from people group by cellphone,contactName").toDF()
//    res.map(x => (x(0).toString, (x(0).toString, x(1).toString, x(2).toString.toInt)))
//      .filter(x => x._1 != null && x._2._2.trim.length >= 2)
//      .filter(x => fastName.indexOf(x._2._2.substring(0, 1)).toInt > -1)
//      .rdd.groupByKey().flatMap(
//      _._2.toArray.sortBy(_._3)(Ordering[Int].reverse).take(1)
//    ).toDF()
//      .withColumnRenamed("_1", "cellphone")
//      .withColumnRenamed("_2", "name")
//      .withColumnRenamed("_3", "cnt")
//      .show()
//
//    // 停止
//    spark.stop()
  }


  override def doTask_04(): Unit = {
//    import org.apache.spark.sql.SparkSession
//
//    val spark = SparkSession.builder
//      .master("local")
//      .appName("Java Spark SQL basic example")
//      .config("spark.some.config.option", "some-value")
//      .getOrCreate
//
//
//    def stringReplace(string: String): String = {
//      string.replace("\"", "")
//    }
//    // 引入架包
//    import spark.implicits._
//
//    val fastName: String = "王,李,张,刘,陈,杨,黄,吴,赵,周,徐,孙,马,朱,胡,林,郭,何,高,罗,郑,梁,谢,宋,唐,许,邓,冯,韩,曹,曾,彭,肖,蔡,潘,田,董,袁,于,余,蒋," + "叶,杜,苏,魏,程,吕,丁,沈,任,姚,卢,钟,姜,崔,谭,廖,范,汪,陆,金,石,戴,贾,韦,夏,邱,方,侯,邹,熊,孟,秦,白,江,闫,薛,尹,付,段,雷,黎,史,龙,贺,陶,顾,龚,郝," + "毛,邵,万,钱,严,洪,赖,武,傅,莫,孔,汤,向,常,温,康,施,文,牛,樊,葛,邢,安,齐,易,乔,伍,庞,颜,倪,庄,聂,章,鲁,岳,翟,申,殷,詹,占,欧,耿,关,兰,焦,俞,左,柳," + "甘,祝,包,宁,符,阮,尚,舒,纪,柯,梅,童,毕,凌,单,季,成,霍,苗,裴,涂,谷,曲,盛,冉,翁,蓝,骆,路,游,靳,辛,欧阳,管,柴,蒙,鲍,华,喻,祁,房,蒲,滕,萧,屈,饶,解,牟" + ",艾,尤,时,阳,穆,农,司,古,吉,卓,车,简,连,芦,缪,项,麦,褚,窦,娄,戚,岑,党,宫,景,卜,费,冷,晏,覃,卫,习,席,柏,米,宗,代,桂,瞿,全,苟,闵,佟,应,臧,边,卞,姬," + "邬,和,师,仇,候,栾,隋,刁,沙,商,寇,荣,巫,郎,桑,丛,阎,甄,敖,虞,仲,池,巩,明,佘,查,麻,苑,迟,邝,封,官,谈,鞠,匡,惠,荆,乐,冀,胥,郁,南,班,储,原,栗,燕,楚" + ",鄢,劳,谌,奚,皮,蔺,楼,粟,冼,盘,满,闻,位,厉,伊,仝,区,郜,海,阚,花,权,强,帅,屠,豆,朴,盖,练,廉,禹,井,巴,漆,祖,丰,支,卿,国,狄,平,计,索,宣,晋,相,初,门" + ",云,容,敬,来,扈,晁,都,芮,普,阙,戈,浦,伏,薄,鹿,邸,雍,辜,阿,羊,母,乌,亓,裘,修,邰,杭,赫,况,那,宿,鲜,逯,印,隆,茹,诸,战,慕,危,玉,银,亢,公,嵇,哈,湛,宾" + ",勾,茅,戎,利,扬,於,呼,居,干,揭,但,尉,斯,元,束,檀,衣,信,阴,展,昝,智,幸,奉,植,富,衡,尧,由,哀,爱,昂,熬,傲,奥,把,百,摆,拜,邦,宝,保,暴,北,贝,贲,本,闭" + ",碧,薜,别,邴,伯,博,补,布,步,部,才,采,彩,菜,仓,苍,藏,操,曽,茶,产,昌,苌,畅,倡,唱,钞,超,巢,朝,潮,沉,晨,呈,承,赤,敕,崇,瘳,丑,除,楮,揣,传,春,淳,啜,慈" + ",次,从,催,翠,寸,达,笪,答,丹,旦,淡,刀,道,德,迪,底,第,佃,定,东,冬,懂,钭,堵,端,敦,顿,多,朵,鄂,恩,尔,佴,法,番,藩,凡,芳,飞,斐,风,酆,逢,凤,俸,扶,苻,洑" + ",浮,福,甫,府,复,淦,刚,皋,杲,格,庚,弓,恭,拱,贡,供,缑,菇,贯,冠,光,广,归,贵,呙,虢,果,过,还,寒,汉,行,蒿,好,昊,浩,禾,合,河,荷,黑,恒,弘,红,宏,鸿,后,厚" + ",忽,湖,虎,户,滑,化,怀,淮,槐,环,桓,宦,皇,辉,回,会,火,伙,基,稽,及,汲,戢,籍,记,继,暨,加,佳,家,嘉,郏,荚,甲,菅,翦,蹇,见,建,剑,将,降,娇,矫,徼,缴,教,接" + ",节,杰,颉,介,京,经,靖,静,酒,咎,琚,菊,巨,句,具,俱,剧,矍,军,君,俊,卡,开,凯,勘,堪,考,科,可,克,空,库,蒯,郐,旷,奎,蒉,阔,喇,稂,朗,勒,蕾,类,梨,礼,里,理" + ",力,历,立,丽,励,郦,莲,良,粱,疗,寥,列,吝,泠,零,另,令,留,庐,炉,禄,伦,洛,雒,闾,侣,律,绿,买,曼,茆,卯,冒,么,枚,美,梦,弥,糜,弭,宓,秘,密,妙,闽,敏,名,谬" + ",磨,墨,默,木,沐,牧,睦,纳,娜,乃,铙,能,尼,年,念,乜,钮,鸥,偶,攀,泮,逄,朋,蓬,澎,骈,濮,溥,柒,其,奇,祈,耆,綦,千,乾,潜,羌,谯,郄,钦,琴,勤,青,清,庆,丘,秋" + ",求,渠,璩,却,荛,绕,仁,日,融,如,汝,瑞,闰,润,若,撒,萨,赛,伞,森,厦,山,闪,陕,善,赏,上,韶,卲,绍,厍,莘,神,甚,慎,升,生,绳,圣,诗,拾,矢,士,世,侍,是,释,守" + ",首,寿,殳,书,疏,树,双,水,税,顺,思,松,送,素,眭,睢,随,所,锁,塔,台,太,泰,郯,潭,塘,桃,淘,腾,藤,提,遆,天,帖,铁,通,同,徒,脱,陀,庹,拓,完,宛,旺,望,威,巍," + "伟,隗,未,蔚,问,瓮,沃,无,毋,吾,仵,兀,西,希,郗,息,溪,袭,洗,喜,霞,仙,先,贤,咸,线,香,湘,象,宵,箫,潇,晓,孝,校,忻,星,刑,兴,雄,吁,须,顼,绪,续,轩,禤,玄," + "学,雪,寻,郇,荀,牙,雅,焉,延,言,岩,彦,艳,宴,洋,仰,养,样,幺,侥,药,要,冶,野,业,依,仪,夷,怡,宜,乙,蚁,弋,义,奕,羿,益,裔,翼,英,盈,营,永,勇,犹,油,友,有," + "迂,鱼,宇,羽,庾,遇,誉,毓,员,源,远,院,月,悦,越,允,运,恽,载,宰,迮,增,甑,粘,斩,长,仉,掌,钊,招,兆,肇,折,真,阵,镇,征,正,政,只,职,郅,治,中,忠,衷,种,皱," + "邾,珠,竹,竺,主,壮,禚,资,子,紫,訾,自,字,纵,俎,佐"
//
//    //      id                      bigint
//    //      cellphone               bigint
//    //      user_id                 bigint
//    //      contact_cellphone       bigint
//    //      contact_name            string
//    //      contact_last_updated_timestamp  string
//    //      contacted_count         string
//    //      last_time_contacted     string
//    //      create_user             bigint
//    //      create_time             string
//    //      update_user             bigint
//    //      update_time             string
//    case class FlumeDataAddress(id: String, cellphone: String, userId: String, contactCellphone: String, contactName: String)
//    spark.sparkContext.textFile("hdfs://emr-header-1.cluster-115354:9000/user/hadoop/flume/duck/address/*")
//      .map(_.split(","))
//      .map(data => FlumeDataAddress(stringReplace(data(0)), stringReplace(data(1)), stringReplace(data(2)), stringReplace(data(3)), stringReplace(data(4))))
//      .toDF().createOrReplaceTempView("address")
//    val addressDF = spark.sql("select * from address").toDF()
//
//    //      id                      bigint
//    //      user_id                 bigint
//    //      be_attention_user_id    bigint
//    //      attention_content       string
//    //      is_valid                int
//    //      create_time             string
//    //      create_user             bigint
//    //      update_time             string
//    //      update_user             bigint
//    case class FlumeDataUserAttentionRecord(id: String, userId: String, beAttentionUserId: String, attentionContent: String)
//    spark.sparkContext.textFile("hdfs://emr-header-1.cluster-115354:9000/user/hadoop/flume/duck/userAttentionRecord/*")
//      .map(_.split(","))
//      .map(data => FlumeDataUserAttentionRecord(stringReplace(data(0)), stringReplace(data(1)), stringReplace(data(2)), stringReplace(data(3))))
//      .toDF().createOrReplaceTempView("user_attention_record")
//    val userAttentionRecordDF = spark.sql("select * from user_attention_record").toDF()
//
//    //      id                      bigint
//    //      user_pic                string
//    //      user_nick_name          string
//    //      user_sex                int
//    //      user_type               int
//    //      create_user             bigint
//    //      create_time             string
//    //      update_user             bigint
//    //      update_time             string
//    //      is_valid                int
//    case class FlumeDataUserBaseInfo(id: String, userNickName: String)
//    spark.sparkContext.textFile("hdfs://emr-header-1.cluster-115354:9000/user/hadoop/flume/duck/userBaseInfo/*")
//      .map(_.split(","))
//      .map(data => FlumeDataUserBaseInfo(stringReplace(data(0)), stringReplace(data(2))))
//      .toDF().createOrReplaceTempView("user_base_info")
//    val userBaseInfoDF = spark.sql("select * from user_base_info").toDF()
//
//    //      id                      bigint
//    //      user_id                 bigint
//    //      be_user_id              bigint
//    //      user_remark             string
//    //      is_valid                int
//    //      create_time             string
//    //      create_user             bigint
//    //      update_time             string
//    //      update_user             bigint
//    case class FlumeDataUserRemark(id: String, userId: String, beUserId: String, userRemark: String)
//    spark.sparkContext.textFile("hdfs://emr-header-1.cluster-115354:9000/user/hadoop/flume/duck/userRemark/*")
//      .map(_.split(","))
//      .map(data => FlumeDataUserRemark(stringReplace(data(0)), stringReplace(data(1)), stringReplace(data(2)), stringReplace(data(3))))
//      .toDF().createOrReplaceTempView("user_remark")
//    val userRemarkDF = spark.sql("select * from user_remark").toDF()
//
//    //contactCellphone,contactName
//    val adf = addressDF.map(x => (x(3).toString, x(4).toString))
//      .filter(x => x._2 != null && x._2.toString.trim.length >= 2)
//      .filter(x => fastName.indexOf(x._2.toString.substring(0, 1)).toInt > -1)
//      .map(x => (x._1, x._2, 1))
//      .toDF().cache()
//
//    //beAttentionUserId,attentionContent
//    userAttentionRecordDF.map(x => (x(2).toString, x(3).toString))
//      .filter(x => x._2 != null && x._2.toString.trim.length >= 2)
//      .filter(x => fastName.indexOf(x._2.toString.substring(0, 1)).toInt > -1)
//      .map(x => (x._1, x._2, 1))
//      .toDF().cache()
//
//    //id,userNickName
//    userBaseInfoDF.map(x => (x(0).toString, x(1).toString))
//      .filter(x => x._2 != null && x._2.toString.trim.length >= 2)
//      .filter(x => fastName.indexOf(x._2.toString.substring(0, 1)).toInt > -1)
//      .map(x => (x._1, x._2, 1))
//      .toDF().cache()
//
//    //beUserId,userRemark
//    userRemarkDF.map(x => (x(2).toString, x(3).toString))
//      .filter(x => x._2 != null && x._2.toString.trim.length >= 2)
//      .filter(x => fastName.indexOf(x._2.toString.substring(0, 1)).toInt > -1)
//      .map(x => (x._1, x._2, 1))
//      .toDF().cache()
//
//    // 停止
//    spark.stop()
  }
}
