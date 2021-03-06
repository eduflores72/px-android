package com.mercadopago.android.px.tracking.internal.views;

import android.support.annotation.NonNull;
import com.mercadopago.android.px.model.DiscountConfigurationModel;
import com.mercadopago.android.px.model.ExpressMetadata;
import com.mercadopago.android.px.preferences.CheckoutPreference;
import com.mercadopago.android.px.tracking.internal.model.OneTapData;
import java.util.Map;
import java.util.Set;

public class OneTapViewTracker extends ViewTracker {

    public static final String PATH_REVIEW_ONE_TAP_VIEW = BASE_VIEW_PATH + "/review/one_tap";

    private final Map<String, Object> data;

    public OneTapViewTracker(final Iterable<ExpressMetadata> expressMetadataList,
        @NonNull final CheckoutPreference checkoutPreference,
        @NonNull final DiscountConfigurationModel discountModel,
        @NonNull final Set<String> cardsWithEsc,
        @NonNull final Set<String> cardsWithSplit,
        final int disabledMethodsQuantity) {
        data =
            OneTapData.createFrom(expressMetadataList, checkoutPreference, discountModel, cardsWithEsc, cardsWithSplit,
                disabledMethodsQuantity)
                .toMap();
    }

    @NonNull
    @Override
    public Map<String, Object> getData() {
        return data;
    }

    @NonNull
    @Override
    public String getViewPath() {
        return PATH_REVIEW_ONE_TAP_VIEW;
    }
}
