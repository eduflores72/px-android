package com.mercadopago.android.px.internal.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mercadopago.android.px.configuration.AdvancedConfiguration;
import com.mercadopago.android.px.configuration.PaymentConfiguration;
import com.mercadopago.android.px.model.Currency;
import com.mercadopago.android.px.model.Site;
import com.mercadopago.android.px.model.Token;
import com.mercadopago.android.px.model.commission.PaymentTypeChargeRule;
import com.mercadopago.android.px.model.internal.Configuration;
import com.mercadopago.android.px.preferences.CheckoutPreference;
import java.util.List;

public interface PaymentSettingRepository {

    void reset();

    void configure(@NonNull final AdvancedConfiguration advancedConfiguration);

    void configure(@NonNull final String publicKey);

    void configure(@NonNull final Site site);

    void configure(@NonNull final Currency currency);

    void configure(@Nullable final CheckoutPreference checkoutPreference);

    void configure(@Nullable final PaymentConfiguration paymentConfiguration);

    void configure(@NonNull Configuration configuration);

    void configure(@NonNull Token token);

    void clearToken();

    void configurePreferenceId(@Nullable String preferenceId);

    void configurePrivateKey(@Nullable final String privateKey);

    @NonNull
    List<PaymentTypeChargeRule> chargeRules();

    @NonNull
    PaymentConfiguration getPaymentConfiguration();

    @Nullable
    CheckoutPreference getCheckoutPreference();

    @Nullable
    String getCheckoutPreferenceId();

    @NonNull
    String getPublicKey();

    @NonNull
    Site getSite();

    @NonNull
    Currency getCurrency();

    @NonNull
    String getTransactionId();

    @NonNull
    AdvancedConfiguration getAdvancedConfiguration();

    @Nullable
    String getPrivateKey();

    @NonNull
    Configuration getConfiguration();

    @Nullable
    Token getToken();

    boolean hasToken();
}