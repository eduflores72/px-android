package com.mercadopago.android.px.internal.viewmodel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.mercadopago.android.px.R;
import com.mercadopago.android.px.internal.util.TextUtil;
import com.mercadopago.android.px.internal.util.textformatter.AmountLabeledFormatter;
import com.mercadopago.android.px.internal.view.PaymentMethodDescriptorView;
import com.mercadopago.android.px.model.AccountMoneyMetadata;

public class AccountMoneyDescriptorModel extends PaymentMethodDescriptorView.Model {

    private final AccountMoneyMetadata accountMoneyMetadata;
    private String sliderTitle = TextUtil.EMPTY;

    @NonNull
    public static PaymentMethodDescriptorView.Model createFrom(
        @NonNull final AccountMoneyMetadata accountMoneyMetadata) {
        return new AccountMoneyDescriptorModel(accountMoneyMetadata);
    }

    /* default */ AccountMoneyDescriptorModel(@NonNull final AccountMoneyMetadata accountMoneyMetadata) {
        this.accountMoneyMetadata = accountMoneyMetadata;
    }

    @Override
    public void updateLeftSpannable(@NonNull final SpannableStringBuilder spannableStringBuilder,
        @NonNull final TextView textView) {

        final Context context = textView.getContext();

        if (accountMoneyMetadata.displayInfo != null) {
            sliderTitle = accountMoneyMetadata.displayInfo.sliderTitle;
            if (TextUtil.isEmpty(sliderTitle)) {
                spannableStringBuilder.append(TextUtil.SPACE);
            } else {
                final AmountLabeledFormatter amountLabeledFormatter =
                    new AmountLabeledFormatter(spannableStringBuilder, context)
                        .withTextColor(ContextCompat.getColor(context, R.color.ui_meli_grey));
                amountLabeledFormatter.apply(sliderTitle);
            }
        }
    }

    @Override
    protected String getAccessibilityContentDescription(@NonNull final Context context) {
        return sliderTitle;
    }
}