package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val (right, wrong) = evaluateRightAndWrongPosition(secret, guess)

    return Evaluation(right, wrong)
}

fun evaluateRightAndWrongPosition(secret: String, guess: String): Pair<Int, Int> {
    var rightPosition = 0
    val secretList = secret.toMutableList()
    val guessList = guess.toMutableList()

    for (index in secret.indices) {
        if (secret[index] == guess[index]) {
            secretList.remove(secret[index])
            guessList.remove(guess[index])
            ++rightPosition
        }
    }

    val wrongPosition = calculateWrongPosition(secretList, guessList)

    return Pair(rightPosition, wrongPosition)
}

fun calculateWrongPosition(secret: MutableList<Char>, guess: MutableList<Char>): Int {
    var wrongPosition = 0

    for (char in secret) {
        if(guess.contains(char)) {
            guess.remove(char)
            ++wrongPosition
        }
    }
    return wrongPosition
}