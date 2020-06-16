package com.israis007.materialcreditcard.views

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
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

            attrsModel = AttrsModel(
                CardType = AttrsModel.getCardType(getInt(R.styleable.SingleCreditCard_CardType, resources.getInteger(R.integer.CardType))),
                CardBrandLogo = AttrsModel.getCardBrandLogo(getInt(R.styleable.SingleCreditCard_CardType, resources.getInteger(R.integer.CardBrandLogo))),
                CardFrontBackground = getDrawable(R.styleable.SingleCreditCard_CardFrontBackground) ?: resources.getDrawable(R.drawable.card, theme),
                CardBackBackground = getDrawable(R.styleable.SingleCreditCard_CardBackBackground) ?: resources.getDrawable(R.drawable.card, theme),
                ChipIcon = getDrawable(R.styleable.SingleCreditCard_ChipIcon) ?: resources.getDrawable(R.drawable.ic_chip, theme),
                ChipLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_ChipLocation, resources.getInteger(R.integer.ChipLocation))),
                ChipMarginStart = getDimension(R.styleable.SingleCreditCard_ChipMarginStart, resources.getDimension(R.dimen.ChipMarginStart)),
                ChipMarginTop = getDimension(R.styleable.SingleCreditCard_ChipMarginTop, resources.getDimension(R.dimen.NoDimen)),
                ChipMarginEnd = getDimension(R.styleable.SingleCreditCard_ChipMarginEnd, resources.getDimension(R.dimen.NoDimen)),
                ChipMarginBottom = getDimension(R.styleable.SingleCreditCard_ChipMarginBottom, resources.getDimension(R.dimen.ChipMarginBottom)),
                ChipHeight = getDimension(R.styleable.SingleCreditCard_ChipHeight, resources.getDimension(R.dimen.ChipHeight)),
                ChipWidth = getDimension(R.styleable.SingleCreditCard_ChipWidth, resources.getDimension(R.dimen.ChipWidth)),
                BrandTypeDrawable = getDrawable(R.styleable.SingleCreditCard_BrandTypeDrawable) ?: resources.getDrawable(R.drawable.ic_mc_symbol, theme),
                BrandTypeLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_BrandTypeLocation, resources.getInteger(R.integer.BrandTypeLocation))),
                BrandTypeMarginStart = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginStart, resources.getDimension(R.dimen.BrandTypeMarginStart)),
                BrandTypeMarginTop = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginTop, resources.getDimension(R.dimen.BrandTypeMarginTop)),
                BrandTypeMarginEnd = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginEnd, resources.getDimension(R.dimen.NoDimen)),
                BrandTypeMarginBottom = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginBottom, resources.getDimension(R.dimen.NoDimen)),
                BrandTypeHeight = getDimension(R.styleable.SingleCreditCard_BrandTypeHeight, resources.getDimension(R.dimen.BrandTypeHeight)),
                BrandTypeWidth = getDimension(R.styleable.SingleCreditCard_BrandTypeWidth, resources.getDimension(R.dimen.BrandTypeWidth)),
                BrandBankDrawable = getDrawable(R.styleable.SingleCreditCard_BrandBankDrawable) ?: resources.getDrawable(R.drawable.ic_citibanamex, theme),
                BrandBankLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_BrandBankLocation, resources.getInteger(R.integer.BrandBankLocation))),
                BrandBankMarginStart = getDimension(R.styleable.SingleCreditCard_BrandBankMarginStart, resources.getDimension(R.dimen.BrandBankMarginStart)),
                BrandBankMarginTop = getDimension(R.styleable.SingleCreditCard_BrandBankMarginTop, resources.getDimension(R.dimen.BrandBankMarginTop)),
                BrandBankMarginEnd = getDimension(R.styleable.SingleCreditCard_BrandBankMarginEnd, resources.getDimension(R.dimen.NoDimen)),
                BrandBankMarginBottom = getDimension(R.styleable.SingleCreditCard_BrandBankMarginBottom, resources.getDimension(R.dimen.NoDimen)),
                BrandBankHeight = getDimension(R.styleable.SingleCreditCard_BrandBankHeight, resources.getDimension(R.dimen.BrandBankHeight)),
                BrandBankWidth = getDimension(R.styleable.SingleCreditCard_BrandBankWidth, resources.getDimension(R.dimen.BrandBankWidth)),
                NumberText = getString(R.styleable.SingleCreditCard_NumberText) ?: resources.getString(R.string.CardNumber),
                NumberTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                NumberTextSize = getDimension(R.styleable.SingleCreditCard_NumberTextSize, resources.getDimension(R.dimen.NumberTextSize)),
                NumberTextColor = getColor(R.styleable.SingleCreditCard_NumberTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                NumberTextMask = getString(R.styleable.SingleCreditCard_NumberTextMask) ?: resources.getString(R.string.CardDateMask),
                NumberTextMaskLength = getInt(R.styleable.SingleCreditCard_NumberTextMaskLength, resources.getInteger(R.integer.NumberTextMaskLength)),
                NumberShow = getBoolean(R.styleable.SingleCreditCard_NumberShow, resources.getBoolean(R.bool.ShowNumber)),
                NumberSide = AttrsModel.getSide(getInt(R.styleable.SingleCreditCard_NumberSide, resources.getInteger(R.integer.NumberSide))),
                NumberLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_NumberLocation, resources.getInteger(R.integer.NumberLocation))),
                NumberMarginStart = getDimension(R.styleable.SingleCreditCard_NumberMarginStart, resources.getDimension(R.dimen.NumberMarginStart)),
                NumberMarginTop = getDimension(R.styleable.SingleCreditCard_NumberMarginTop, resources.getDimension(R.dimen.NoDimen)),
                NumberMarginEnd = getDimension(R.styleable.SingleCreditCard_NumberMarginEnd, resources.getDimension(R.dimen.NumberMarginEnd)),
                NumberMarginBottom = getDimension(R.styleable.SingleCreditCard_NumberMarginBottom, resources.getDimension(R.dimen.NumberMarginBottom)),
                NumberHeight = getDimension(R.styleable.SingleCreditCard_NumberHeight, resources.getDimension(R.dimen.NoDimen)),
                NumberWidth = getDimension(R.styleable.SingleCreditCard_NumberWidth, resources.getDimension(R.dimen.NoDimen)),
                NameText = getString(R.styleable.SingleCreditCard_NameText) ?: resources.getString(R.string.CardName),
                NameTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                NameTextSize = getDimension(R.styleable.SingleCreditCard_NameTextSize, resources.getDimension(R.dimen.NameTextSize)),
                NameTextColor = getColor(R.styleable.SingleCreditCard_NameTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                NameSide = AttrsModel.getSide(getInt(R.styleable.SingleCreditCard_NameSide, resources.getInteger(R.integer.NameSide))),
                NameLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_NameLocation, resources.getInteger(R.integer.NameLocation))),
                NameShow = getBoolean(R.styleable.SingleCreditCard_NameShow, resources.getBoolean(R.bool.ShowName)),
                NameMarginStart = getDimension(R.styleable.SingleCreditCard_NameMarginStart, resources.getDimension(R.dimen.NameMarginStart)),
                NameMarginTop = ,
                NameMarginEnd = ,
                NameMarginBottom = ,
                NameHeight = ,
                NameWidth = ,
                DateText = ,
                DateTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
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
                ClientSinceTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
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
                SecurityCodeFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                SecurityCodeTextSize = ,
                SecurityCodeTextColor = ,
                SecurityCodeLocation =
            )
        }
    }

}