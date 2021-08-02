package designmode.creation.builder;

/**
 * 制作奶茶 建造者设计模式
 *
 * @author Defu Li
 * @date 2021/8/3 0:02
 */
public class MilkTea {
    private boolean ice;
    private String sugar;
    private String tasteType;

    private MilkTea(Builder builder) {
        this.ice = builder.ice;
        this.sugar = builder.sugar;
        this.tasteType = builder.tasteType;
    }

    public boolean getIce() {
        return ice;
    }

    public String getSugar() {
        return sugar;
    }

    public String getTasteType() {
        return tasteType;
    }

    public static class Builder {
        public boolean ice = true;
        public String sugar = "3分";
        public String tasteType;

        public Builder(String tasteType) {
            this.tasteType = tasteType;
        }

        public Builder setIce(boolean ice) {
            this.ice = ice;
            return this;
        }

        public Builder setSugar(String sugar) {
            this.sugar = sugar;
            return this;
        }

        public MilkTea build() {
            return new MilkTea(this);
        }
    }
}
