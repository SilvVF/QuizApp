package com.example.quizapp

import kotlin.random.Random

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val THEME_LIST: String = "theme_list"
    private val questionWho = "what is this characters name"
    private val questionPerson = "what is this persons name"
    private val questionShow = "What show is this from"
    fun getQuestions(themeList: List<Int>):ArrayList<Question>{
        if(themeList.isEmpty()){
            return getQuestions(listOf(Random.nextInt(0,2)))
        }
        val questionsList = ArrayList<Question>()
        if(themeList.contains(0)) {
                val que1 = Question(
                    id = 0,
                    question = questionWho,
                    image = R.drawable.baki,
                    optionOne = "Ebisu",
                    optionTwo = "Baki",
                    optionThree = "Ao",
                    optionFour = "Hidan",
                    correctAns = 1,
                )
                questionsList.add(que1)
                val que2 = Question(
                    id = 1,
                    question = questionWho,
                    image = R.drawable.guren,
                    optionOne = "Hebiichigo",
                    optionTwo = "Pakura",
                    optionThree = "Mei",
                    optionFour = "Guren",
                    correctAns = 4,
                )
                questionsList.add(que2)

                val que3 = Question(
                    id = 2,
                    question = questionWho,
                    image = R.drawable.riruka,
                    optionOne = "Riruka",
                    optionTwo = "Yoruichi",
                    optionThree = "Nel",
                    optionFour = "Orihime",
                    correctAns = 1,
                )
                questionsList.add(que3)
                val que4 = Question(
                    id = 3,
                    question = questionShow,
                    image = R.drawable.another,
                    optionOne = "Naruto",
                    optionTwo = "Bleach",
                    optionThree = "Another",
                    optionFour = "Horimiya",
                    correctAns = 3,
                )
                questionsList.add(que4)
                val que5 = Question(
                    id = 6,
                    question = questionShow,
                    image = R.drawable.fmasymbol,
                    optionOne = "Full Metal Alchemist",
                    optionTwo = "Attack On titan",
                    optionThree = "Another",
                    optionFour = "Mob Psycho 100",
                    correctAns = 1,
                )
                questionsList.add(que5)
                val que6 = Question(
                    id = 4,
                    question = questionWho,
                    image = R.drawable.mikey,
                    optionOne = "Draken",
                    optionTwo = "Mikey",
                    optionThree = "Osanai",
                    optionFour = "Tanjiro",
                    correctAns = 2,
                )
                questionsList.add(que6)
                val que7 = Question(
                    id = 7,
                    question = questionShow,
                    image = R.drawable.naruto_seal,
                    optionOne = "Tokyo Ghoul",
                    optionTwo = "Bleach",
                    optionThree = "Kakgurui",
                    optionFour = "Naruto",
                    correctAns = 4,
                )
                questionsList.add(que7)
                val que8 = Question(
                    id = 8,
                    question = questionShow,
                    image = R.drawable.steins_bana,
                    optionOne = "Steins Gate",
                    optionTwo = "Your Name",
                    optionThree = "One Piece",
                    optionFour = "Food Wars",
                    correctAns = 1,
                )
                questionsList.add(que8)
            }
            if(themeList.contains(1)){
                val que9 = Question(
                    id = 9,
                    question = questionPerson,
                    image = R.drawable.tenz,
                    optionOne = "TenZ",
                    optionTwo = "s1mple",
                    optionThree = "shroud",
                    optionFour = "Aceu",
                    correctAns = 1,
                )
                questionsList.add(que9)

                val que10 = Question(
                    id = 10,
                    question = questionPerson,
                    image = R.drawable.aceu,
                    optionOne = "TenZ",
                    optionTwo = "s1mple",
                    optionThree = "shroud",
                    optionFour = "Aceu",
                    correctAns = 4,
                )
                questionsList.add(que10)

                val que11 = Question(
                    id = 11,
                    question = questionWho,
                    image = R.drawable.snake,
                    optionOne = "Solid Snake",
                    optionTwo = "Agent 47",
                    optionThree = "Sam Fisher",
                    optionFour = "Captain Price",
                    correctAns = 1,
                )
                questionsList.add(que11)

                val que12 = Question(
                    id = 12,
                    question = "What series is this character from",
                    image = R.drawable.cortana,
                    optionOne = "Splinter Cell",
                    optionTwo = "Cyber Bug",
                    optionThree = "Halo",
                    optionFour = "Call of Duty",
                    correctAns = 3,
                )
                questionsList.add(que12)

                val que13 = Question(
                    id = 13,
                    question = "What game is this",
                    image = R.drawable.lock,
                    optionOne = "Fortnite",
                    optionTwo = "Roblox",
                    optionThree = "Battlegrounds",
                    optionFour = "Total LetDown",
                    correctAns = 4,
                )
                questionsList.add(que13)

            }

            if(themeList.contains(2)) {

            }

        return questionsList
    }

}

