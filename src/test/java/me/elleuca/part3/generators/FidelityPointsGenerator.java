package me.elleuca.part3.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import me.elleuca.part3.FidelityPoints;
import me.elleuca.part3.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FidelityPointsGenerator extends Generator<FidelityPoints> {

    private static int minBonus = 0;
    private static int maxBonus = Integer.MAX_VALUE;

    public FidelityPointsGenerator() {
        super(FidelityPoints.class);
    }

    @Override
    public FidelityPoints generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        return new FidelityPoints(UUID.randomUUID(), generateProducts(sourceOfRandomness, generationStatus));
    }

    /**
     * Creates a {@link Product} list of random length.
     * The total bonus count of the list is random between {@value #minBonus} and {@value #maxBonus}
     *
     * @param sourceOfRandomness
     * @param generationStatus
     * @return
     */
    private List<Product> generateProducts(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        List<Product> products = new ArrayList<>();

        int randomTotalBonus = sourceOfRandomness.nextInt(minBonus, maxBonus);

        while (randomTotalBonus > 0) {
            int randomProductBonus = sourceOfRandomness.nextInt(0, 1);
            products.add(new Product(UUID.randomUUID(), "Name", randomProductBonus));
            randomTotalBonus = randomTotalBonus - randomProductBonus;
        }

        return  products;
    }

    public void configure(InBonusRange range) {
        this.minBonus = range.minBonus();
        this.maxBonus = range.maxBonus();
    }
}
