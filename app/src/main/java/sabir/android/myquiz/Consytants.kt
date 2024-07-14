package sabir.android.myquiz

object Consytants {
    const val USER_NAME :String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val COORECT_ANSWERS:String="correct_answer"

    fun GetQuestions() : ArrayList<Question>{
        val QuestionsList = ArrayList<Question>()

        val que1 = Question(
            1, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina","France","Australia","India",1
        )
        QuestionsList.add(que1)

        val que2 = Question(
            2, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Poland","Australia","Canada","Swedan",2
        )
        QuestionsList.add(que2)

        val que3 = Question(
            3, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "India","Pakistan","Belgium","Germany",3
        )
        QuestionsList.add(que3)

        val que4 = Question(
            4, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India","Pakistan","Mexico","Belgium",1
        )
        QuestionsList.add(que4)

        val que5 = Question(
            5, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "France","USA","Alaska","Brazil",4
        )
        QuestionsList.add(que5)

        val que6 = Question(
            6, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark","New Zeland","China","Russia",
            1
        )
        QuestionsList.add(que6)

        val que7 = Question(
            7, "Who is this cartoon character?",
            R.drawable.ic_flag_of_fiji,
            "England","Greenland","Fiji","Chad",3
        )
        QuestionsList.add(que7)

        val que8 = Question(
            8, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Japan","South Korea","Germany","Norway",3
        )
        QuestionsList.add(que8)

        val que9 = Question(
            9, "Whose house is this?",
            R.drawable.ic_flag_of_kuwait,
            "India","Afghanistan","Kuwait","Bangladesh",3
        )
        QuestionsList.add(que9)
        return QuestionsList
    }
}