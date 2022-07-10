package enums;

public enum CurrencyEnum {

    LKR("Sri Lanka Rupee (LKR)"),
    USD("US Dollar (USD)"),
    CAD("Canadian Dollar (CAD)");

    private String currency;

    CurrencyEnum(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
