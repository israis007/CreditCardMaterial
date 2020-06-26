package com.israis007.materialcreditcard.models

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import com.israis007.materialcreditcard.R

data class AttrsModel (
    var CardType: CardType,
    var CardBrandLogo: CardBrandLogo,
    var DefaultDrawableMasterCard: Drawable?,
    var DefaultDrawableVISA: Drawable?,
    var DefaultDrawableAmericanExpress: Drawable?,
    var DefaultDrawableDiscovery: Drawable?,
    var DefaultDrawableUnionPay: Drawable?,
    var DefaultDrawableUnknown: Drawable?,
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
    var ChipShow: Boolean,
    var BrandTypeDrawable: Drawable,
    var BrandTypeLocation: Location,
    var BrandTypeMarginStart: Float,
    var BrandTypeMarginTop: Float,
    var BrandTypeMarginEnd: Float,
    var BrandTypeMarginBottom: Float,
    var BrandTypeHeight: Float,
    var BrandTypeWidth: Float,
    var BrandTypeShow: Boolean,
    var BrandBankDrawable: Drawable,
    var BrandBankLocation: Location,
    var BrandBankMarginStart: Float,
    var BrandBankMarginTop: Float,
    var BrandBankMarginEnd: Float,
    var BrandBankMarginBottom: Float,
    var BrandBankHeight: Float,
    var BrandBankWidth: Float,
    var BrandBankShow: Boolean,
    var NumberText: String,
    var NumberTextFont: Typeface,
    var NumberTextSize: Float,
    @ColorInt
    var NumberTextColor: Int,
    var NumberTextMask: TextMask,
    var NumberTextMaskLength: Int,
    var NumberSide: Side,
    var NumberLocation: Location,
    var NumberMarginStart: Float,
    var NumberMarginTop: Float,
    var NumberMarginEnd: Float,
    var NumberMarginBottom: Float,
    var NumberHeight: Float,
    var NumberWidth: Float,
    var NumberShow: Boolean,
    var NameText: String,
    var NameTextFont: Typeface,
    var NameTextSize: Float,
    @ColorInt
    var NameTextColor: Int,
    var NameSide: Side,
    var NameLocation: Location,
    var NameMarginStart: Float,
    var NameMarginTop: Float,
    var NameMarginEnd: Float,
    var NameMarginBottom: Float,
    var NameHeight: Float,
    var NameWidth: Float,
    var NameShow: Boolean,
    var DateText: String,
    var DateTextFont: Typeface,
    var DateTextSize: Float,
    @ColorInt
    var DateTextColor: Int,
    var DateTextFormat: String,
    var DateTextShow: Boolean,
    var DateSide: Side,
    var DateLocation: Location,
    var DateMarginStart: Float,
    var DateMarginTop: Float,
    var DateMarginEnd: Float,
    var DateMarginBottom: Float,
    var DateHeight: Float,
    var DateWidth: Float,
    var DateShow: Boolean,
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
    var ClientSinceShow: Boolean,
    var MagneticBandDrawable: Drawable,
    var SignDrawable: Drawable,
    var SignLocation: Location,
    var SignMarginStart: Float,
    var SignMarginTop: Float,
    var SignMarginEnd: Float,
    var SignMarginBottom: Float,
    var SignHeight: Float,
    var SignWidth: Float,
    var SignShow: Boolean,
    var SecurityCodeText: String,
    var SecurityCodeFont: Typeface,
    var SecurityCodeTextSize: Float,
    @ColorInt
    var SecurityCodeTextColor: Int,
    var SecurityCodeLocation: CodeLocation,
    var SecurityCodeShow: Boolean,
    var Separator: Separator
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

        fun getLogoBrandByCardType(cardType: CardType) =
            when (cardType){
                CardType.MASTER_CARD -> CardType.MASTER_CARD.drawable ?: CardBrandLogo.MASTER_CARD_NEW_SYMBOL.resourceId
                CardType.VISA -> CardType.VISA.drawable ?: CardBrandLogo.VISA_NEW.resourceId
                CardType.AMERICAN_EXPRESS -> CardType.AMERICAN_EXPRESS.drawable ?: CardBrandLogo.AMERICAN_EXPRESS.resourceId
                CardType.DISCOVERY -> CardType.DISCOVERY.drawable ?: CardBrandLogo.DISCOVERY.resourceId
                CardType.UNION_PAY -> CardType.UNION_PAY.drawable ?: CardBrandLogo.UNION_PAY.resourceId
                else -> CardType.UNKNOWN.drawable ?: CardBrandLogo.UNKNOWN.resourceId
            }

        fun getCardBrandLogo(value: Int): CardBrandLogo =
            when (value) {
                0 -> CardBrandLogo.MASTER_CARD_NEW_SYMBOL
                1 -> CardBrandLogo.MASTER_CARD_NEW_MARK_VERTICAL
                2 -> CardBrandLogo.MASTER_CARD_NEW_MARK_HORIZONTAL
                3 -> CardBrandLogo.MASTER_CARD_OLD
                4 -> CardBrandLogo.VISA_NEW
                5 -> CardBrandLogo.VISA_NEW_WHITE
                6 -> CardBrandLogo.VISA_NEW_BLUE
                7 -> CardBrandLogo.VISA_OLD
                8 -> CardBrandLogo.DISCOVERY
                9 -> CardBrandLogo.UNION_PAY
                10 -> CardBrandLogo.AMERICAN_EXPRESS
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

        fun getSeparator(value: Int): Separator =
            when (value) {
                0 -> Separator.NONE
                1 -> Separator.SLASH
                2 -> Separator.SPACE
                else -> Separator.HYPHEN
            }
    }
}

enum class CardType (val value: Int, var drawable: Drawable?) {
    MASTER_CARD(0, null),
    VISA(1, null),
    AMERICAN_EXPRESS(2, null),
    DISCOVERY(3, null),
    UNION_PAY(4, null),
    UNKNOWN(5, null)
}

enum class CardBrandLogo (val value: Int, val resourceId: Int) {
    MASTER_CARD_NEW_SYMBOL(0, R.drawable.ic_mc_symbol),
    MASTER_CARD_NEW_MARK_VERTICAL(1, R.drawable.ic_mc_vertical),
    MASTER_CARD_NEW_MARK_HORIZONTAL(2, R.drawable.ic_mc_horizontal),
    MASTER_CARD_OLD(3, R.drawable.ic_mc_old),
    VISA_NEW(4, R.drawable.ic_visa_new),
    VISA_NEW_WHITE(5, R.drawable.ic_visa_new_white),
    VISA_NEW_BLUE(6, R.drawable.ic_visa_new_blue),
    VISA_OLD(7, R.drawable.ic_visa_old),
    DISCOVERY(8, R.drawable.ic_discovery_card),
    UNION_PAY(9, R.drawable.ic_union_pay),
    AMERICAN_EXPRESS(10, R.drawable.ic_amex),
    UNKNOWN(11, R.drawable.ic_money)
}

enum class Location (val value: Int) {
    LEFT_TOP(0),
    LEFT_BOTTOM(1),
    RIGHT_TOP(2),
    RIGHT_BOTTOM(3)
}

enum class TextMask (val value: Int, val char: Char) {
    NONE(0, 0.toChar()),
    ASTERISK(1, '*'),
    X(2, 'X'),
    MIDDLE_DOT(3, '·')
}

enum class Separator (val value: Int, val char: Char) {
    NONE(0, 0.toChar()),
    SLASH(1, '/'),
    SPACE(2, ' '),
    HYPHEN(3, '-')
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