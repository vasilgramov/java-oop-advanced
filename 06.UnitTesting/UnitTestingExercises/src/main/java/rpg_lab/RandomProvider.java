package rpg_lab;

import jdk.management.resource.internal.inst.RandomAccessFileRMHooks;

import java.util.Random;

public interface RandomProvider {

    int nextInt(int max);

    class Implementation implements RandomProvider {
        private Random random;

        public Implementation(Random random) {
            this.random = random;
        }

        public int nextInt(int max) {
            return this.random.nextInt(max);
        }
    }
}
