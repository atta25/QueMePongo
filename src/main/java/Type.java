public enum Type {
    SHIRT(Category.HIGHER) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return currentTemperature >= 24.0;
        }
    },
    TSHIRT(Category.HIGHER) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return currentTemperature >= 24.0;
        }
    },
    JACKET(Category.HIGHER) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return currentTemperature <= 17.5;
        }
    },
    CHOMBA(Category.HIGHER) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return currentTemperature >= 24.0;
        }
    },
    TROUSER(Category.LOWER) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return currentTemperature <= 30.0;
        }
    },
    SHOE(Category.FOOTWEAR) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return true;
        }
    },
    SNEAKER(Category.FOOTWEAR) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return true;
        }
    },
    HAT(Category.ACCESSORY) {
        @Override
        protected Boolean isSuitable(Double currentTemperature) {
            return currentTemperature <= 17.5;
        }
    };

    private Category category;

    Type(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }

    abstract protected Boolean isSuitable(Double currentTemperature);
}
