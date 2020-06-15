package com.israis007.materialcreditcard.views

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import androidx.core.content.withStyledAttributes
import androidx.core.view.get
import com.israis007.materialcreditcard.R
import com.israis007.materialcreditcard.models.AttrsModel

class SingleCreditCard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private lateinit var attrsModel: AttrsModel

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.SingleCreditCard,
            defStyleAttr,
            R.style.SingleCreditCardStyle
        ){
            val resources = context.resources
            val theme = context.theme
            //AttrsModel.getCardType(getInt(R.styleable.SingleCreditCard_CardType, reso.getInteger(R.integer.)))
            attrsModel = AttrsModel(
                CardType = AttrsModel.getCardType(getInt(R.styleable.SingleCreditCard_CardType, resources.getInteger(R.integer.CardType))),
                CardBrandLogo = AttrsModel.getCardBrandLogo(getInt(R.styleable.SingleCreditCard_CardType, resources.getInteger(R.integer.CardBrandLogo))),
                CardFrontBackground = getDrawable(R.styleable.SingleCreditCard_CardFrontBackground) ?: resources.getDrawable(R.drawable.card, theme),
                CardBackBackground = getDrawable(R.styleable.SingleCreditCard_CardBackBackground) ?: resources.getDrawable(R.drawable.card, theme),
                ChipIcon = getDrawable(R.styleable.SingleCreditCard_ChipIcon) ?: resources.getDrawable(R.drawable.ic_chip, theme),
                ChipLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_ChipLocation, resources.getInteger(R.integer.ChipLocation))),
                ChipMarginStart = ,
                ChipMarginTop = ,
                ChipMarginEnd = ,
                ChipMarginBottom = ,
                ChipHeight = ,
                ChipWidth = ,
                BrandTypeDrawable = ,
                BrandTypeLocation = ,
                BrandTypeMarginStart = ,
                BrandTypeMarginTop = ,
                BrandTypeMarginEnd = ,
                BrandTypeMarginBottom = ,
                BrandTypeHeight = ,
                BrandTypeWidth = ,
                BrandBankDrawable = ,
                BrandBankLocation = ,
                BrandBankMarginStart = ,
                BrandBankMarginTop = ,
                BrandBankMarginEnd = ,
                BrandBankMarginBottom = ,
                BrandBankHeight = ,
                BrandBankWidth = ,
                NumberText = ,
                NumberTextFont = ,
                NumberTextSize = ,
                NumberTextColor = ,
                NumberTextMask = ,
                NumberTextMaskLength = ,
                NumberShow = ,
                NumberSide = ,
                NumberLocation = ,
                NumberMarginStart = ,
                NumberMarginTop = ,
                NumberMarginEnd = ,
                NumberMarginBottom = ,
                NumberHeight = ,
                NumberWidth = ,
                NameText = ,
                NameTextFont = ,
                NameTextSize = ,
                NameTextColor = ,
                NameSide = ,
                NameLocation = ,
                NameShow = ,
                NameMarginStart = ,
                NameMarginTop = ,
                NameMarginEnd = ,
                NameMarginBottom = ,
                NameHeight = ,
                NameWidth = ,
                DateText = ,
                DateTextFont = ,
                DateTextSize = ,
                DateTextColor = ,
                DateTextFormat = ,
                DateSide = ,
                DateLocation = ,
                DateMarginStart = ,
                DateMarginTop = ,
                DateMarginEnd = ,
                DateMarginBottom = ,
                DateHeight = ,
                DateWidth = ,
                ClientSinceText = ,
                ClientSinceTextFont = ,
                ClientSinceTextSize = ,
                ClientSinceTextColor = ,
                ClientSinceSide = ,
                ClientSinceLocation = ,
                ClientSinceMarginStart = ,
                ClientSinceMarginTop = ,
                ClientSinceMarginEnd = ,
                ClientSinceMarginBottom = ,
                ClientSinceHeight = ,
                ClientSinceWidth = ,
                MagneticBandDrawable = ,
                SignDrawable = ,
                SignLocation = ,
                SignMarginStart = ,
                SignMarginTop = ,
                SignMarginEnd = ,
                SignMarginBottom = ,
                SignShow = ,
                SignHeight = ,
                SignWidth = ,
                SecurityCodeText = ,
                SecurityCodeFont = ,
                SecurityCodeTextSize = ,
                SecurityCodeTextColor = ,
                SecurityCodeLocation =
            )
        }
    }

}