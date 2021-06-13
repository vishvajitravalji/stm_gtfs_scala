package ca.mcit.bigdata.scala

  trait Stm_Join[X,Y,Out] {
    def join(n:List[X],   m:List[Y]):List[Out]
  }

  case class JoinValue(left: Any,right:Option[Any])

  class MapJoin[X,Y] (val joinfunc: (X ) => String)(val joinCondition1: (Y) => String)extends Stm_Join[X,Y,JoinValue]{
      override def join(n: List[X], m: List[Y]): List[JoinValue] ={
      val l:Map[String,Y] = m.map(m=>joinCondition1(m) ->m).toMap
        n.filter(n=>l.contains(joinfunc(n))).map(n=> JoinValue(n,Some(l(joinfunc(n)))))
    }
  }

  class GenericNestedLoopJoin[X,Y](val joinfunc:(X,Y)=>Boolean)extends Stm_Join[X,Y,JoinValue] {
    override def join(x: List[X], y: List[Y]): List[JoinValue] = for {
      n <- x
      m <- y
      if joinfunc(n, m)
    }
      yield JoinValue(n, Some(m))
  }

