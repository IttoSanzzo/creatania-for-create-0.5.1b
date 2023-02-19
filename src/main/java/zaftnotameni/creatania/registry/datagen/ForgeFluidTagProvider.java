package zaftnotameni.creatania.registry.datagen;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import zaftnotameni.creatania.Constants;
import zaftnotameni.creatania.registry.Fluids;
import zaftnotameni.creatania.registry.Tags;
public class ForgeFluidTagProvider extends FluidTagsProvider {
  public ForgeFluidTagProvider(DataGenerator generator, ExistingFileHelper helper) {
    super(generator, Constants.MODID, helper);
  }

  @Override
  protected void addTags() {
    tag(Tags.Fluids.PURE_INERT_MANA).add(Fluids.PURIFIED_MANA_FLUID.fluid.get());
    tag(Tags.Fluids.CORRUPT_INERT_MANA).add(Fluids.CORRUPT_MANA_FLUID.fluid.get());
  }
}

