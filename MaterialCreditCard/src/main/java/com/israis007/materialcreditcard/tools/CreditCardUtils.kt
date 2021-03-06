package com.israis007.materialcreditcard.tools

import androidx.annotation.NonNull
import com.israis007.materialcreditcard.models.Separator
import com.israis007.materialcreditcard.models.TextMask
import java.lang.StringBuilder
import java.util.*
import java.util.regex.Pattern
import kotlin.math.abs

private const val PATTERN_AMEX = "^3(4|7)[0-9 ]*"
private const val PATTERN_VISA = "^4[0-9 ]*"
private const val PATTERN_MASTER = "^5[0-9 ]*"
private const val PATTERN_DISCOVER = "^60[0-9 ]*"
private const val PATTERN_UNION_PAY = "^62[0-9 ]*"

const val MAX_LENGTH_CARD_NUMBER = 16
const val MAX_LENGTH_CARD_NUMBER_AMEX = 15

const val CARD_NUMBER_FORMAT = "XXXX XXXX XXXX XXXX"
const val CARD_NUMBER_FORMAT_AMEX = "XXXX XXXXXX XXXXX"


class CreditCardUtils {

    enum class CardType(val value: Int) {
        UNKNOWN_CARD(0),
        AMEX_CARD(1),
        MASTER_CARD(2),
        VISA_CARD(3),
        DISCOVER_CARD(4),
        UNION_PAY_CARD(5)
    }

    enum class CardSide(val value: Int) {
        FRONT(1),
        BACK(2)
    }

    enum class CardPage(val value: Int) {
        NUMBER(0),
        EXPIRY(1),
        CVV(2),
        NAME(3)
    }

    companion object {
        fun getCardLength(cardType: CardType) =
            if (cardType == CardType.AMEX_CARD)
                MAX_LENGTH_CARD_NUMBER_AMEX
            else
                MAX_LENGTH_CARD_NUMBER

        fun selectCardType(cardNumber: String): CardType {
            var pattern = Pattern.compile(PATTERN_VISA)
            if (pattern.matcher(cardNumber).matches())
                return CardType.VISA_CARD

            pattern = Pattern.compile(PATTERN_MASTER)
            if (pattern.matcher(cardNumber).matches())
                return CardType.MASTER_CARD

            pattern = Pattern.compile(PATTERN_AMEX)
            if (pattern.matcher(cardNumber).matches())
                return CardType.AMEX_CARD

            pattern = Pattern.compile(PATTERN_DISCOVER)
            if (pattern.matcher(cardNumber).matches())
                return CardType.DISCOVER_CARD

            pattern = Pattern.compile(PATTERN_UNION_PAY)
            if (pattern.matcher(cardNumber).matches())
                return CardType.UNION_PAY_CARD

            return CardType.UNKNOWN_CARD
        }

        fun handleCardNumber(
            inputCardNumber: String,
            separator: Separator,
            textMask: TextMask
        ): String {
            val unformattedText = inputCardNumber.replace(separator.char.toString(), "")
            val cardType = selectCardType(inputCardNumber)
            val format =
                if (cardType == CardType.AMEX_CARD) CARD_NUMBER_FORMAT_AMEX else CARD_NUMBER_FORMAT
            val stringBuilder = StringBuilder()

            var iIdx = 0
            var jIdx = 0
            while (iIdx < format.length && unformattedText.length > jIdx) {
                if (format[iIdx] == textMask.char) stringBuilder.append(
                    unformattedText[jIdx++]
                ) else stringBuilder.append(format[iIdx])
                iIdx++
            }
            return stringBuilder.toString()
        }

        fun formatCardNumber(
            inputCardNumber: String,
            separator: Separator,
            textMask: TextMask,
            length: Int
        ): String {
            val unformattedText = inputCardNumber.replace(separator.char.toString(), "")
            val cardType = selectCardType(unformattedText)
            val format =
                if (cardType == CardType.AMEX_CARD) CARD_NUMBER_FORMAT_AMEX else CARD_NUMBER_FORMAT
            val maxLength =
                if (cardType == CardType.AMEX_CARD) MAX_LENGTH_CARD_NUMBER_AMEX else MAX_LENGTH_CARD_NUMBER
            var chars =
                if (maxLength - length < 0 || maxLength - length > maxLength) maxLength else length
            val convertedMask = format.replace('X', if (textMask == TextMask.NONE) 'X' else textMask.char).replace(' ', separator.char)
            val stringBuilder = StringBuilder()

            //Parsing Number
            var spaces = 0
            for (i in format.indices) {
                when {
                    convertedMask[i] == separator.char -> {
                        chars++
                        spaces++
                        stringBuilder.append(separator.char)
                    }
                    i < chars -> stringBuilder.append(convertedMask[i])
                    i >= chars -> {
                        stringBuilder.append(inputCardNumber[i - spaces])
                    }
                }
            }

            return stringBuilder.toString()
        }

        fun handleExpiration(month: String, year: String) =
            Companion.handleExpiration(month + year)

        fun handleExpiration(@NonNull dateYear: String): String {
            val expiry = dateYear.replace(Separator.SLASH.char.toString(), "")

            var text: String

            if (expiry.length >= 2) {
                var mm = expiry.substring(0, 2)
                var yy: String
                text = mm

                try {
                    if (mm.toInt() > 12)
                        mm = "12"
                } catch (e: Exception) {
                    mm = "01"
                }

                if (expiry.length >= 4) {
                    yy = expiry.substring(2, 4)

                    try {
                        yy.toInt()
                    } catch (e: Exception) {
                        val calendar = Calendar.getInstance()
                        val year = calendar[Calendar.YEAR]
                        yy = year.toString().substring(2)
                    }

                    text = mm + Separator.SLASH.char + yy
                } else if (expiry.length > 2) {
                    yy = expiry.substring(2)
                    text = mm + Separator.SLASH.char + yy
                }
            } else
                text = expiry

            return text
        }

    }

}