package com.israis007.materialcreditcard.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.withStyledAttributes
import com.bumptech.glide.Glide
import com.israis007.materialcreditcard.R
import com.israis007.materialcreditcard.models.AttrsModel
import com.israis007.materialcreditcard.models.CardType
import com.israis007.materialcreditcard.models.Location
import com.israis007.materialcreditcard.tools.CreditCardUtils

class SingleCreditCard @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private lateinit var attrsModel: AttrsModel
    private lateinit var brandIV: AppCompatImageView
    private lateinit var numberTV: AppCompatTextView
    private lateinit var nameTV: AppCompatTextView
    private lateinit var dateTV: AppCompatTextView
    lateinit var constraintLayout: ConstraintLayout

    init {
        setBackgroundColor(Color.LTGRAY)
        context.withStyledAttributes(
            attrs,
            R.styleable.SingleCreditCard,
            defStyleAttr,
            R.style.SingleCreditCardStyle
        ){
            val resources = context.resources
            val theme = context.theme
            setBackgroundColor(Color.LTGRAY)
            attrsModel = AttrsModel(
                CardType = AttrsModel.getCardType(getInt(R.styleable.SingleCreditCard_CardType, resources.getInteger(R.integer.CardType))),
                CardBrandLogo = AttrsModel.getCardBrandLogo(getInt(R.styleable.SingleCreditCard_CardType, resources.getInteger(R.integer.CardBrandLogo))),
                DefaultDrawableMasterCard = getDrawable(R.styleable.SingleCreditCard_DefaultDrawableMasterCard),
                DefaultDrawableVISA = getDrawable(R.styleable.SingleCreditCard_DefaultDrawableVISA),
                DefaultDrawableAmericanExpress = getDrawable(R.styleable.SingleCreditCard_DefaultDrawableAmericanExpress),
                DefaultDrawableDiscovery = getDrawable(R.styleable.SingleCreditCard_DefaultDrawableDiscovery),
                DefaultDrawableUnionPay = getDrawable(R.styleable.SingleCreditCard_DefaultDrawableUnionPay),
                DefaultDrawableUnknown = getDrawable(R.styleable.SingleCreditCard_DefaultDrawableUnknown),
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
                ChipShow = getBoolean(R.styleable.SingleCreditCard_ChipShow, resources.getBoolean(R.bool.chipShow)),
                BrandTypeDrawable = getDrawable(R.styleable.SingleCreditCard_BrandTypeDrawable) ?: resources.getDrawable(R.drawable.ic_mc_symbol, theme),
                BrandTypeLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_BrandTypeLocation, resources.getInteger(R.integer.BrandTypeLocation))),
                BrandTypeMarginStart = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginStart, resources.getDimension(R.dimen.NoDimen)),
                BrandTypeMarginTop = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginTop, resources.getDimension(R.dimen.NoDimen)),
                BrandTypeMarginEnd = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginEnd, resources.getDimension(R.dimen.BrandTypeMarginEnd)),
                BrandTypeMarginBottom = getDimension(R.styleable.SingleCreditCard_BrandTypeMarginBottom, resources.getDimension(R.dimen.BrandTypeMarginBottom)),
                BrandTypeHeight = getDimension(R.styleable.SingleCreditCard_BrandTypeHeight, resources.getDimension(R.dimen.BrandTypeHeight)),
                BrandTypeWidth = getDimension(R.styleable.SingleCreditCard_BrandTypeWidth, resources.getDimension(R.dimen.BrandTypeWidth)),
                BrandTypeShow = getBoolean(R.styleable.SingleCreditCard_BrandTypeShow, resources.getBoolean(R.bool.brandTypeShow)),
                BrandBankDrawable = getDrawable(R.styleable.SingleCreditCard_BrandBankDrawable) ?: resources.getDrawable(R.drawable.ic_bank, theme),
                BrandBankLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_BrandBankLocation, resources.getInteger(R.integer.BrandBankLocation))),
                BrandBankMarginStart = getDimension(R.styleable.SingleCreditCard_BrandBankMarginStart, resources.getDimension(R.dimen.BrandBankMarginStart)),
                BrandBankMarginTop = getDimension(R.styleable.SingleCreditCard_BrandBankMarginTop, resources.getDimension(R.dimen.BrandBankMarginTop)),
                BrandBankMarginEnd = getDimension(R.styleable.SingleCreditCard_BrandBankMarginEnd, resources.getDimension(R.dimen.NoDimen)),
                BrandBankMarginBottom = getDimension(R.styleable.SingleCreditCard_BrandBankMarginBottom, resources.getDimension(R.dimen.NoDimen)),
                BrandBankHeight = getDimension(R.styleable.SingleCreditCard_BrandBankHeight, resources.getDimension(R.dimen.BrandBankHeight)),
                BrandBankWidth = getDimension(R.styleable.SingleCreditCard_BrandBankWidth, resources.getDimension(R.dimen.BrandBankWidth)),
                BrandBankShow = getBoolean(R.styleable.SingleCreditCard_BrandBankShow, resources.getBoolean(R.bool.brandBankShow)),
                NumberText = getString(R.styleable.SingleCreditCard_NumberText) ?: resources.getString(R.string.CardNumber),
                NumberTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                NumberTextSize = getDimension(R.styleable.SingleCreditCard_NumberTextSize, resources.getDimension(R.dimen.NumberTextSize)),
                NumberTextColor = getColor(R.styleable.SingleCreditCard_NumberTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                NumberTextMask = AttrsModel.getTextMask(getInt(R.styleable.SingleCreditCard_NumberTextMask, resources.getInteger(R.integer.NumberMask))),
                NumberTextMaskLength = getInt(R.styleable.SingleCreditCard_NumberTextMaskLength, resources.getInteger(R.integer.NumberTextMaskLength)),
                NumberSide = AttrsModel.getSide(getInt(R.styleable.SingleCreditCard_NumberSide, resources.getInteger(R.integer.NumberSide))),
                NumberLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_NumberLocation, resources.getInteger(R.integer.NumberLocation))),
                NumberMarginStart = getDimension(R.styleable.SingleCreditCard_NumberMarginStart, resources.getDimension(R.dimen.NumberMarginStart)),
                NumberMarginTop = getDimension(R.styleable.SingleCreditCard_NumberMarginTop, resources.getDimension(R.dimen.NumberMarginTop)),
                NumberMarginEnd = getDimension(R.styleable.SingleCreditCard_NumberMarginEnd, resources.getDimension(R.dimen.NumberMarginEnd)),
                NumberMarginBottom = getDimension(R.styleable.SingleCreditCard_NumberMarginBottom, resources.getDimension(R.dimen.NumberMarginBottom)),
                NumberHeight = getDimension(R.styleable.SingleCreditCard_NumberHeight, resources.getDimension(R.dimen.NoDimen)),
                NumberWidth = getDimension(R.styleable.SingleCreditCard_NumberWidth, resources.getDimension(R.dimen.NoDimen)),
                NumberShow = getBoolean(R.styleable.SingleCreditCard_NumberShow, resources.getBoolean(R.bool.numberShow)),
                NameText = getString(R.styleable.SingleCreditCard_NameText) ?: resources.getString(R.string.CardName),
                NameTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_NumberTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                NameTextSize = getDimension(R.styleable.SingleCreditCard_NameTextSize, resources.getDimension(R.dimen.NameTextSize)),
                NameTextColor = getColor(R.styleable.SingleCreditCard_NameTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                NameSide = AttrsModel.getSide(getInt(R.styleable.SingleCreditCard_NameSide, resources.getInteger(R.integer.NameSide))),
                NameLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_NameLocation, resources.getInteger(R.integer.NameLocation))),
                NameMarginStart = getDimension(R.styleable.SingleCreditCard_NameMarginStart, resources.getDimension(R.dimen.NameMarginStart)),
                NameMarginTop = getDimension(R.styleable.SingleCreditCard_NameMarginTop, resources.getDimension(R.dimen.NameMarginTop)),
                NameMarginEnd = getDimension(R.styleable.SingleCreditCard_NameMarginEnd, resources.getDimension(R.dimen.NameMarginEnd)),
                NameMarginBottom = getDimension(R.styleable.SingleCreditCard_NameMarginBottom, resources.getDimension(R.dimen.NameMarginBottom)),
                NameHeight = getDimension(R.styleable.SingleCreditCard_NameHeight, resources.getDimension(R.dimen.NoDimen)),
                NameWidth = getDimension(R.styleable.SingleCreditCard_NameWidth, resources.getDimension(R.dimen.NoDimen)),
                NameShow = getBoolean(R.styleable.SingleCreditCard_NameShow, resources.getBoolean(R.bool.nameShow)),
                DateText = getString(R.styleable.SingleCreditCard_DateText) ?: resources.getString(R.string.CardDate),
                DateTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_DateTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                DateTextSize = getDimension(R.styleable.SingleCreditCard_DateTextSize, resources.getDimension(R.dimen.DateTextSize)),
                DateTextColor = getColor(R.styleable.SingleCreditCard_DateTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                DateTextFormat = getString(R.styleable.SingleCreditCard_DateTextFormat) ?: resources.getString(R.string.CardDateMask),
                DateTextShow = getBoolean(R.styleable.SingleCreditCard_DateTextShow, resources.getBoolean(R.bool.dateTextShow)),
                DateSide = AttrsModel.getSide(getInt(R.styleable.SingleCreditCard_DateSide, resources.getInteger(R.integer.DateSide))),
                DateLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_DateLocation, resources.getInteger(R.integer.DateLocation))),
                DateMarginStart = getDimension(R.styleable.SingleCreditCard_DateMarginStart, resources.getDimension(R.dimen.DateMarginStart)),
                DateMarginTop = getDimension(R.styleable.SingleCreditCard_DateMarginTop, resources.getDimension(R.dimen.NoDimen)),
                DateMarginEnd = getDimension(R.styleable.SingleCreditCard_DateMarginEnd, resources.getDimension(R.dimen.NoDimen)),
                DateMarginBottom = getDimension(R.styleable.SingleCreditCard_DateMarginBottom, resources.getDimension(R.dimen.DateMarginBottom)),
                DateHeight = getDimension(R.styleable.SingleCreditCard_DateHeight, resources.getDimension(R.dimen.DateHeight)),
                DateWidth = getDimension(R.styleable.SingleCreditCard_DateWidth, resources.getDimension(R.dimen.DateWidth)),
                DateShow = getBoolean(R.styleable.SingleCreditCard_DateShow, resources.getBoolean(R.bool.dateShow)),
                ClientSinceText = getString(R.styleable.SingleCreditCard_ClientSinceText) ?: resources.getString(R.string.ClientSince),
                ClientSinceTextFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_ClientSinceTextFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                ClientSinceTextSize = getDimension(R.styleable.SingleCreditCard_ClientSinceTextSize, resources.getDimension(R.dimen.ClientSinceTextSize)),
                ClientSinceTextColor = getColor(R.styleable.SingleCreditCard_ClientSinceTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                ClientSinceSide = AttrsModel.getSide(getInt(R.styleable.SingleCreditCard_ClientSinceSide, resources.getInteger(R.integer.ClientSinceSide))),
                ClientSinceLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_ClientSinceLocation, resources.getInteger(R.integer.ClientSinceLocation))),
                ClientSinceMarginStart = getDimension(R.styleable.SingleCreditCard_ClientSinceMarginStart, resources.getDimension(R.dimen.ClientSinceMarginStart)),
                ClientSinceMarginTop = getDimension(R.styleable.SingleCreditCard_ClientSinceMarginTop, resources.getDimension(R.dimen.NoDimen)),
                ClientSinceMarginEnd = getDimension(R.styleable.SingleCreditCard_ClientSinceMarginEnd, resources.getDimension(R.dimen.NoDimen)),
                ClientSinceMarginBottom = getDimension(R.styleable.SingleCreditCard_ClientSinceMarginBottom, resources.getDimension(R.dimen.ClientSinceMarginBottom)),
                ClientSinceHeight = getDimension(R.styleable.SingleCreditCard_ClientSinceHeight, resources.getDimension(R.dimen.ClientSinceHeight)),
                ClientSinceWidth = getDimension(R.styleable.SingleCreditCard_ClientSinceWidth, resources.getDimension(R.dimen.ClientSinceWidth)),
                ClientSinceShow = getBoolean(R.styleable.SingleCreditCard_ClientSinceShow, resources.getBoolean(R.bool.clientSinceShow)),
                MagneticBandDrawable = getDrawable(R.styleable.SingleCreditCard_MagneticStripeDrawable) ?: resources.getDrawable(R.drawable.magnetic_stripe, theme),
                SignDrawable = getDrawable(R.styleable.SingleCreditCard_SignDrawable) ?: resources.getDrawable(R.drawable.sign_stripe, theme),
                SignLocation = AttrsModel.getLocation(getInt(R.styleable.SingleCreditCard_SignLocation, resources.getInteger(R.integer.SignLocation))),
                SignMarginStart = getDimension(R.styleable.SingleCreditCard_SignMarginStart, resources.getDimension(R.dimen.SignMarginStart)),
                SignMarginTop = getDimension(R.styleable.SingleCreditCard_SignMarginTop, resources.getDimension(R.dimen.SignMarginTop)),
                SignMarginEnd = getDimension(R.styleable.SingleCreditCard_SignMarginEnd, resources.getDimension(R.dimen.SignMarginEnd)),
                SignMarginBottom = getDimension(R.styleable.SingleCreditCard_SignMarginBottom, resources.getDimension(R.dimen.SignMarginBottom)),
                SignHeight = getDimension(R.styleable.SingleCreditCard_SignHeight, resources.getDimension(R.dimen.SignHeight)),
                SignWidth = getDimension(R.styleable.SingleCreditCard_SignWidth, resources.getDimension(R.dimen.SignWidth)),
                SignShow = getBoolean(R.styleable.SingleCreditCard_SignShow, resources.getBoolean(R.bool.signShow)),
                SecurityCodeText = getString(R.styleable.SingleCreditCard_SecurityCodeText) ?: resources.getString(R.string.CardSecurityCode),
                SecurityCodeFont = try { ResourcesCompat.getFont(context, getResourceId(R.styleable.SingleCreditCard_SecurityCodeFont, R.font.halter))!! } catch (e: Exception) { ResourcesCompat.getFont(context, R.font.halter)!! },
                SecurityCodeTextSize = getDimension(R.styleable.SingleCreditCard_SecurityCodeTextSize, resources.getDimension(R.dimen.SecurityCodeTextSize)),
                SecurityCodeTextColor = getColor(R.styleable.SingleCreditCard_SecurityCodeTextColor, ContextCompat.getColor(context, R.color.NumberColor)),
                SecurityCodeLocation = AttrsModel.getCodeLocation(getInt(R.styleable.SingleCreditCard_SecurityCodeLocation, resources.getInteger(R.integer.SecurityCodeLocation))),
                SecurityCodeShow = getBoolean(R.styleable.SingleCreditCard_SecurityCodeShow, resources.getBoolean(R.bool.securityCodeShow)),
                Separator = AttrsModel.getSeparator(getInt(R.styleable.SingleCreditCard_NumberTextSeparator, resources.getInteger(R.integer.Separator)))
            )
        }

        invalidate()
        drawCard()
        requestLayout()
    }

    private fun drawCard(){
        constraintLayout = ConstraintLayout(context)
        val rootLp= ConstraintLayout.LayoutParams (
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        constraintLayout.id = View.generateViewId()
        constraintLayout.layoutParams = rootLp
        radius = context.resources.getDimension(R.dimen.RadiusCard)
        background = attrsModel.CardFrontBackground

        /* Add Brand */
        if (attrsModel.BrandBankShow) {
            val imageBrand = AppCompatImageView(context)
            imageBrand.id = View.generateViewId()
            val brandLp =
                createNewLayoutParams(attrsModel.BrandBankWidth, attrsModel.BrandBankHeight)
            brandLp.setMargins(
                getSizeInt(attrsModel.BrandBankMarginStart),
                getSizeInt(attrsModel.BrandBankMarginTop),
                getSizeInt(attrsModel.BrandBankMarginEnd),
                getSizeInt(attrsModel.BrandBankMarginBottom)
            )
            applyRules(attrsModel.BrandBankLocation, brandLp)
            imageBrand.layoutParams = brandLp
            Glide.with(context).load(attrsModel.BrandBankDrawable).centerInside().fitCenter()
                .into(imageBrand)
            constraintLayout.addView(imageBrand)
        }

        /* Add Chip */
        if (attrsModel.ChipShow) {
            val imageChip = AppCompatImageView(context)
            imageChip.id = View.generateViewId()
            val chipLp = createNewLayoutParams(attrsModel.ChipWidth, attrsModel.ChipHeight)
            chipLp.setMargins(
                getSizeInt(attrsModel.ChipMarginStart),
                getSizeInt(attrsModel.ChipMarginTop),
                getSizeInt(attrsModel.ChipMarginEnd),
                getSizeInt(attrsModel.ChipMarginBottom)
            )
            applyRules(attrsModel.ChipLocation, chipLp)
            imageChip.layoutParams = chipLp
            Glide.with(context).load(attrsModel.ChipIcon).centerInside().fitCenter().into(imageChip)
            constraintLayout.addView(imageChip)
        }

        /* Add Brand Type */
        if (attrsModel.BrandTypeShow) {
            brandIV = AppCompatImageView(context)
            brandIV.id = View.generateViewId()
            val typeBrandLp =
                createNewLayoutParams(attrsModel.BrandTypeWidth, attrsModel.BrandTypeHeight)
            typeBrandLp.setMargins(
                getSizeInt(attrsModel.BrandTypeMarginStart),
                getSizeInt(attrsModel.BrandTypeMarginTop),
                getSizeInt(attrsModel.BrandTypeMarginEnd),
                getSizeInt(attrsModel.BrandTypeMarginBottom)
            )
            applyRules(attrsModel.BrandTypeLocation, typeBrandLp)
            brandIV.layoutParams = typeBrandLp
            reDrawBrandLogo()
            constraintLayout.addView(brandIV)
        }

        /* Add Number Card View */
        if (attrsModel.NumberShow) {
            numberTV = AppCompatTextView(context)
            numberTV.id = View.generateViewId()
            val numberLp =
                createNewLayoutParams(attrsModel.NumberWidth, if (attrsModel.NumberHeight == 0f) ConstraintLayout.LayoutParams.WRAP_CONTENT.toFloat() else attrsModel.NumberHeight)
            numberLp.setMargins(
                getSizeInt(attrsModel.NumberMarginStart),
                getSizeInt(attrsModel.NumberMarginTop),
                getSizeInt(attrsModel.NumberMarginEnd),
                getSizeInt(attrsModel.NumberMarginBottom)
            )
            numberLp.apply {
                startToStart = 0
                startToEnd = -1
                topToTop = 0
                topToBottom = -1
                endToEnd = 0
                endToStart = -1
                bottomToBottom = 0
                bottomToTop = -1
            }
            numberTV.layoutParams = numberLp
            numberTV.setTextColor(attrsModel.NumberTextColor)
            numberTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, attrsModel.NumberTextSize)
            numberTV.typeface = attrsModel.NumberTextFont
            numberTV.text = CreditCardUtils.formatCardNumber(attrsModel.NumberText, attrsModel.Separator, attrsModel.NumberTextMask, attrsModel.NumberTextMaskLength)
            numberTV.gravity = Gravity.CENTER
            constraintLayout.addView(numberTV)
        }

        /* Add Name View */
        if (attrsModel.NameShow) {
            nameTV = AppCompatTextView(context)
            nameTV.id = View.generateViewId()
            val nameLp =
                createNewLayoutParams(attrsModel.NameWidth, if (attrsModel.NameHeight == 0f) ConstraintLayout.LayoutParams.WRAP_CONTENT.toFloat() else attrsModel.NameHeight)
            nameLp.setMargins(
                getSizeInt(attrsModel.NameMarginStart),
                getSizeInt(attrsModel.NameMarginTop),
                getSizeInt(attrsModel.NameMarginEnd),
                getSizeInt(attrsModel.NameMarginBottom)
            )
            applyRules(attrsModel.NameLocation, nameLp)
            nameTV.layoutParams = nameLp
            nameTV.setTextColor(attrsModel.NameTextColor)
            nameTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, attrsModel.NameTextSize)
            nameTV.typeface = attrsModel.NameTextFont
            nameTV.text = attrsModel.NameText
            nameTV.gravity = Gravity.START
            constraintLayout.addView(nameTV)
        }

        /* Add Date Expiration View */
        if (attrsModel.DateShow) {
            dateTV = AppCompatTextView(context)
            dateTV.id = View.generateViewId()
            val dateLp =
                createNewLayoutParams(attrsModel.DateWidth, attrsModel.DateHeight)
            dateLp.setMargins(
                getSizeInt(attrsModel.DateMarginStart),
                getSizeInt(attrsModel.DateMarginTop),
                getSizeInt(attrsModel.DateMarginEnd),
                getSizeInt(attrsModel.DateMarginBottom)
            )
            applyRules(attrsModel.DateLocation, dateLp)
            dateTV.layoutParams = dateLp
            dateTV.setTextColor(attrsModel.DateTextColor)
            dateTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, attrsModel.DateTextSize)
            dateTV.typeface = attrsModel.DateTextFont
            dateTV.text = attrsModel.DateText
            dateTV.gravity = Gravity.CENTER
            constraintLayout.addView(dateTV)
        }

        /* Add Member Since View */
        if (attrsModel.ClientSinceShow) {
            val clientTV = AppCompatTextView(context)
            clientTV.id = View.generateViewId()
            val clientLp =
                createNewLayoutParams(attrsModel.ClientSinceWidth, attrsModel.ClientSinceHeight)
            clientLp.setMargins(
                getSizeInt(attrsModel.ClientSinceMarginStart),
                getSizeInt(attrsModel.ClientSinceMarginTop),
                getSizeInt(attrsModel.ClientSinceMarginEnd),
                getSizeInt(attrsModel.ClientSinceMarginBottom)
            )
            applyRules(attrsModel.ClientSinceLocation, clientLp)
            clientTV.layoutParams = clientLp
            clientTV.setTextColor(attrsModel.ClientSinceTextColor)
            clientTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, attrsModel.ClientSinceTextSize)
            clientTV.typeface = attrsModel.ClientSinceTextFont
            clientTV.text = attrsModel.ClientSinceText
            clientTV.gravity = Gravity.CENTER
            constraintLayout.addView(clientTV)
        }

        this@SingleCreditCard.addView(constraintLayout)
    }

    private fun getSizeInt(size: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, context.resources.displayMetrics).toInt()

    private fun createNewLayoutParams(width: Float, height: Float): ConstraintLayout.LayoutParams =
        ConstraintLayout.LayoutParams(
            when {
                width > 0 -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, width, context.resources.displayMetrics).toInt()
                width == 0f -> 0
                width == -1f -> ConstraintLayout.LayoutParams.MATCH_PARENT
                else -> ConstraintLayout.LayoutParams.WRAP_CONTENT
            },
            when {
                height > 0 -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, height, context.resources.displayMetrics).toInt()
                height == 0f -> 0
                height == -1f -> ConstraintLayout.LayoutParams.MATCH_PARENT
                else -> ConstraintLayout.LayoutParams.WRAP_CONTENT
            }
        )


    private fun applyRules(location: Location, layoutParams: ConstraintLayout.LayoutParams){
        when (location) {
            Location.LEFT_TOP -> layoutParams.apply {
                startToStart = 0
                startToEnd = -1
                endToEnd = -1
                endToStart = -1
                topToTop = 0
                topToBottom = -1
                bottomToTop = -1
                bottomToBottom = -1
            }

            Location.LEFT_BOTTOM -> layoutParams.apply {
                startToStart = 0
                startToEnd = -1
                endToEnd = -1
                endToStart = -1
                topToTop = -1
                topToBottom = -1
                bottomToTop = -1
                bottomToBottom = 0
            }

            Location.RIGHT_TOP -> layoutParams.apply {
                startToStart = -1
                startToEnd = -1
                endToEnd = 0
                endToStart = -1
                topToTop = 0
                topToBottom = -1
                bottomToTop = -1
                bottomToBottom = -1
            }

            Location.RIGHT_BOTTOM -> layoutParams.apply {
                startToStart = -1
                startToEnd = -1
                endToEnd = 0
                endToStart = -1
                topToTop = -1
                topToBottom = -1
                bottomToTop = -1
                bottomToBottom = 0
            }
        }
    }

    private fun reDrawBrandLogo(){
        Glide.with(context).load(AttrsModel.getLogoBrandByCardType(attrsModel.CardType)).centerInside().fitCenter().error(R.drawable.ic_money).into(brandIV)
    }

    fun setAttrs(attrsModel: AttrsModel){
        this.attrsModel = attrsModel
        invalidate()
        drawCard()
        requestLayout()
    }

    fun getAttrsModel() = this.attrsModel

    fun changeTypeBrand(cardType: CardType){
        attrsModel.CardType = cardType
        reDrawBrandLogo()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null)
            return

    }
}