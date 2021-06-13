package ca.mcit.bigdata.scala

case class Calendar ( service_id:String, monday :Int, tuesday :Int, wednesday:Int, thursday:Int,
                      friday:Int, saturday:Int, sunday:Int, start_date:String, end_date:String )

object Calendar extends App {

  def convertLineToCalendarDates(line: String): Calendar = {
    val fields: Array[String] = line.split(",", -1)
    Calendar(fields(0), fields(1).toInt, fields(2).toInt, fields(3).toInt,fields(4).toInt,fields(5).toInt,
      fields(6).toInt,fields(7).toInt,fields(8),fields(9))
  }

    def convertCalnedercsv(calendar: Calendar): String = {
      calendar.service_id + "," +
        calendar.monday + "," +
        calendar.tuesday + "," +
        calendar.wednesday + "," +
        calendar.thursday + "," +
        calendar.friday + "," +
        calendar.saturday + "," +
        calendar.sunday + "," +
        calendar.start_date + "," +
        calendar.end_date

    }

  }