package com.example.quizapp.data

import com.example.quizapp.data.models.Question
import com.example.quizapp.R
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
        val network1 = R.drawable.network
        val network2 = R.drawable.network_two
        if(themeList.contains(0)) {
                val que1 = Question(
                    id = 0,
                    question = " A type of cryptographic network protocol for secure data communication, remote command-line login, remote command execution, and other secure network services between two networked computers is known as:",
                    image = network1,
                    optionOne = "TFTP",
                    optionTwo = "SSH",
                    optionThree = "Telnet",
                    optionFour = "RDP",
                    correctAns = 2,
                )
                questionsList.add(que1)
                val que2 = Question(
                    id = 1,
                    question = "Which of the answers listed below refers to a secure replacement for Telnet?",
                    image = network1,
                    optionOne = "CHAP",
                    optionTwo = "FTP",
                    optionThree = "SNMP",
                    optionFour = "SSH",
                    correctAns = 4,
                )
                questionsList.add(que2)

                val que3 = Question(
                    id = 2,
                    question = " Which of the following answers refers to a system containing mappings of domain names to various types of data, such as numerical IP addresses?",
                    image = network2,
                    optionOne = "TCP/IP",
                    optionTwo = "DNS",
                    optionThree = "SQL",
                    optionFour = "DHCP",
                    correctAns = 2,
                )
                questionsList.add(que3)
                val que4 = Question(
                    id = 3,
                    question = "The SMTP protocol is can be used for:",
                    image = network1,
                    optionOne = "Sending email between mail servers",
                    optionTwo = "Name resolution",
                    optionThree = "Retrieving email from mail servers",
                    optionFour = "Name resolution",
                    correctAns = 1,
                )
                questionsList.add(que4)
                val que5 = Question(
                    id = 6,
                    question = " A network protocol that allows for secure file transfer over Secure Shell (SSH) is called:",
                    image = network2,
                    optionOne = "TFTP",
                    optionTwo = "SFTP",
                    optionThree = "Telnet",
                    optionFour = "FTPS",
                    correctAns = 2,
                )
                questionsList.add(que5)
                val que6 = Question(
                    id = 4,
                    question = " What is the function of FTP?",
                    image = network2,
                    optionOne = "Mail services",
                    optionTwo = "Serving of web pages",
                    optionThree = "Directory access",
                    optionFour = "File exchange",
                    correctAns = 4,
                )
                questionsList.add(que6)
                val que7 = Question(
                    id = 7,
                    question = "What are the characteristic features of TFTP?",
                    image = network2,
                    optionOne = "Provides no security features",
                    optionTwo = "Directory access protocol",
                    optionThree = "Provides authentication and encryption",
                    optionFour = "Mail service",
                    correctAns = 1,
                )
                questionsList.add(que7)
                val que8 = Question(
                    id = 8,
                    question = "A network protocol providing an alternative solution to the manual allocation of IP addresses is known as:",
                    image = network2,
                    optionOne = "DNS",
                    optionTwo = "SNMP",
                    optionThree = "NAT",
                    optionFour = "DHCP",
                    correctAns = 4,
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

