package com.israis007.materialcreditcard.models

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt

data class AttrsModel (
    var CardType: CardType,
    var CardBrandLogo: CardBrandLogo,
    var CardFrontBackground: Drawable,
    var CardBackBackground: Drawable,
    var ChipIcon: Drawable,
    var ChipLocation: Location,
    var ChipMarginStart: Float,
    var ChipMarginTop: Float,
    var ChipMarginEnd: Float,
    var ChipMarginBottom: Float,
    var ChipHeight: Float,
    var ChipWidth: Float,
    var BrandTypeDrawable: Drawable,
    var BrandTypeLocation: Location,
    var BrandTypeMarginStart: Float,
    var BrandTypeMarginTop: Float,
    var BrandTypeMarginEnd: Float,
    var BrandTypeMarginBottom: Float,
    var BrandTypeHeight: Float,
    var BrandTypeWidth: Float,
    var BrandBankDrawable: Drawable,
    var BrandBankLocation: Location,
    var BrandBankMarginStart: Float,
    var BrandBankMarginTop: Float,
    var BrandBankMarginEnd: Float,
    var BrandBankMarginBottom: Float,
    var BrandBankHeight: Float,
    var BrandBankWidth: Float,
    var NumberText: String,
    var NumberTextFont: Typeface,
    var NumberTextSize: Float,
    @ColorInt
    var NumberTextColor: Int,
    var NumberTextMask: String,
    var NumberTextMaskLength: Int,
    var NumberShow: Boolean,
    var NumberSide: Side,
    var NumberLocation: Location,
    var NumberMarginStart: Float,
    var NumberMarginTop: Float,
    var NumberMarginEnd: Float,
    var NumberMarginBottom: Float,
    var NumberHeight: Float,
    var NumberWidth: Float,
    var NameText: String,
    var NameTextFont: Typeface,
    var NameTextSize: Float,
    @ColorInt
    var NameTextColor: Int,
    var NameSide: Side,
    var NameLocation: Location,
    var NameShow: Boolean,
    var NameMarginStart: Float,
    var NameMarginTop: Float,
    var NameMarginEnd: Float,
    var NameMarginBottom: Float,
    var NameHeight: Float,
    var NameWidth: Float,
    var DateText: String,
    var DateTextFont: Typeface,
    var DateTextSize: Float,
    @ColorInt
    var DateTextColor: Int,
    var DateTextFormat: String,
    var DateSide: Side,
    var DateLocation: Location,
    var DateMarginStart: Float,
    var DateMarginTop: Float,
    var DateMarginEnd: Float,
    var DateMarginBottom: Float,
    var DateHeight: Float,
    var DateWidth: Float,
    var ClientSinceText: String,
    var ClientSinceTextFont: Typeface,
    var ClientSinceTextSize: Float,
    @ColorInt
    var ClientSinceTextColor: Int,
    var ClientSinceSide: Side,
    var ClientSinceLocation: Location,
    var ClientSinceMarginStart: Float,
    var ClientSinceMarginTop: Float,
    var ClientSinceMarginEnd: Float,
    var ClientSinceMarginBottom: Float,
    var ClientSinceHeight: Float,
    var ClientSinceWidth: Float,
    var MagneticBandDrawable: Drawable,
    var SignDrawable: Drawable,
    var SignLocation: Location,
    var SignMarginStart: Float,
    var SignMarginTop: Float,
    var SignMarginEnd: Float,
    var SignMarginBottom: Float,
    var SignShow: Boolean,
    var SignHeight: Float,
    var SignWidth: Float,
    var SecurityCodeText: String,
    var SecurityCodeFont: Typeface,
    var SecurityCodeTextSize: Float,
    @ColorInt
    var SecurityCodeTextColor: Int,
    var SecurityCodeLocation: CodeLocation
){
    companion object {
        fun getCardType(value: Int): CardType =
            when (value) {
                0 -> CardType.MASTER_CARD
                1 -> CardType.VISA
                2 -> CardType.AMERICAN_EXPRESS
                3 -> CardType.DISCOVERY
                4 -> CardType.UNION_PAY
                else -> CardType.UNKNOWN
            }

        fun getCardBrandLogo(value: Int): CardBrandLogo =
            when (value) {
                0 -> CardBrandLogo.MASTER_CARD_NEW_SYMBOL
                1 -> CardBrandLogo.MASTER_CARD_NEW_MARK_VERTICAL
                2 -> CardBrandLogo.MASTER_CARD_NEW_MARK_HORIZONTAL
                3 -> CardBrandLogo.MASTER_CARD_OLD
                4 -> CardBrandLogo.VISA_NEW_WHITE
                5 -> CardBrandLogo.VISA_NEW_BLUE
                6 -> CardBrandLogo.VISA_OLD
                7 -> CardBrandLogo.DISCOVERY
                8 -> CardBrandLogo.UNION_PAY
                else -> CardBrandLogo.UNKNOWN
            }

        fun getLocation(value: Int): Location =
            when (value) {
                0 -> Location.LEFT_TOP
                1 -> Location.LEFT_BOTTOM
                2 -> Location.RIGHT_TOP
                else -> Location.RIGHT_BOTTOM
            }

        fun getTextMask(value: Int): TextMask =
            when (value) {
                0 -> TextMask.NONE
                1 -> TextMask.ASTERISK
                2 -> TextMask.X
                else -> TextMask.MIDDLE_DOT
            }

        fun getSide(value: Int): Side =
            when (value) {
                0 -> Side.FRONT
                else -> Side.BACK
            }

        fun getCodeLocation(value: Int): CodeLocation =
            when (value) {
                0 -> CodeLocation.LEFT_TOP
                1 -> CodeLocation.LEFT_BOTTOM
                2 -> CodeLocation.RIGHT_TOP
                3 -> CodeLocation.RIGHT_BOTTOM
                else -> CodeLocation.END_SIGN_DRAWABLE
            }
    }
}

enum class CardType (val value: Int) {
    MASTER_CARD(0),
    VISA(1),
    AMERICAN_EXPRESS(2),
    DISCOVERY(3),
    UNION_PAY(4),
    UNKNOWN(5)
}

enum class CardBrandLogo (val value: Int) {
    MASTER_CARD_NEW_SYMBOL(0),
    MASTER_CARD_NEW_MARK_VERTICAL(1),
    MASTER_CARD_NEW_MARK_HORIZONTAL(2),
    MASTER_CARD_OLD(3),
    VISA_NEW_WHITE(4),
    VISA_NEW_BLUE(5),
    VISA_OLD(6),
    DISCOVERY(7),
    UNION_PAY(8),
    UNKNOWN(9)
}

enum class Location (val value: Int) {
    LEFT_TOP(0),
    LEFT_BOTTOM(1),
    RIGHT_TOP(2),
    RIGHT_BOTTOM(3)
}

enum class TextMask (val value: Int) {
    NONE(0),
    ASTERISK(1),
    X(2),
    MIDDLE_DOT(3)
}

enum class Side (val value: Int) {
    FRONT(0),
    BACK(1)
}

enum class CodeLocation (val value: Int) {
    LEFT_TOP(0),
    LEFT_BOTTOM(1),
    RIGHT_TOP(2),
    RIGHT_BOTTOM(3),
    END_SIGN_DRAWABLE(4)
}