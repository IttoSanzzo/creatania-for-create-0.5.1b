package zaftnotameni.creatania.registry;

import com.simibubi.create.AllItems;
import com.tterrag.registrate.util.entry.FluidEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import zaftnotameni.creatania.advancements.CreataniaAdvancement;
import zaftnotameni.creatania.util.Humanity;

import static zaftnotameni.creatania.advancements.CreataniaAdvancement.TaskType.NOISY;
import static zaftnotameni.creatania.advancements.CreataniaAdvancement.TaskType.SECRET;
import static zaftnotameni.creatania.advancements.CreataniaAdvancement.TaskType.SILENT;
public class Advancements {
  public static final List<CreataniaAdvancement> ENTRIES = new ArrayList<>();
  public static final CreataniaAdvancement START = null,
    ROOT = create("root", b -> b.icon(zaftnotameni.creatania.registry.Items.MANA_GEL.get())
      .title("Welcome to Creatania")
      .description("Creatania is a Contraption Magical Tech Mod")
      .awardedForFree()
      .special(SILENT)),

  // mana machinery
    MANA_MACHINE_COMPONENT = create("mana_machine_component", b -> b.icon(zaftnotameni.creatania.registry.Blocks.MANA_CASING.get())
      .title("Magical... Stress")
      .description("Obtain a mana machine component, the core of all mana machines")
      .after(ROOT)
      .special(NOISY)
      .whenIconCollected()),
    MANA_GENERATOR = create("mana_generator", b -> b.icon(zaftnotameni.creatania.registry.Blocks.MANA_GENERATOR.get())
      .title("Poolished Mechanics")
      .description("Create your first Mana Generator, now you can convert inert mana fluid to real mana")
      .after(MANA_MACHINE_COMPONENT)
      .special(NOISY)
      .whenIconCollected()),
    OMNI_GEARBOX = create("omni_gearbox", b -> b.icon(Blocks.OMNIBOX.get())
      .title("Ominously Omnidirectional")
      .description("Gearboxes are too limited, enters the omnibox!")
      .after(MANA_MACHINE_COMPONENT)
      .special(NOISY)
      .whenIconCollected()),
    XOR_LEVER = create("xor_lever", b -> b.icon(Blocks.XOR_LEVER.get())
      .title("Cleveraging Exorbitantly")
      .description("Keeping redstone signals under control")
      .after(MANA_MACHINE_COMPONENT)
      .special(NOISY)
      .whenIconCollected()),
    MANADUCT_TIER_1 = create("manaduct_tier_1", b -> b.icon(Blocks.MANASTEEL_MANADUCT_BLOCK.get())
      .title("Fixing mana with duct tape")
      .description("Sending mana from the physical world is a very inefficient process, ducts help mitigate the losses")
      .after(MANA_GENERATOR)
      .special(NOISY)
      .whenIconCollected()),
    MANADUCT_TIER_2 = create("manaduct_tier_2", b -> b.icon(Blocks.TERRASTEEL_MANADUCT_BLOCK.get())
      .title("Duct Tales")
      .description("A more refined duct, further reduces loss during mana transfer from a generator")
      .after(MANADUCT_TIER_1)
      .special(NOISY)
      .whenIconCollected()),
    MANADUCT_TIER_3 = create("manaduct_tier_3", b -> b.icon(Blocks.ELEMENTIUM_MANADUCT_BLOCK.get())
      .title("Elementarium, my dear botanate")
      .description("An elven better duct, the folks in alfheim really know their stuff")
      .after(MANADUCT_TIER_2)
      .special(NOISY)
      .whenIconCollected()),
    MANADUCT_TIER_4 = create("manaduct_tier_4", b -> b.icon(Blocks.GAIA_MANADUCT_BLOCK.get())
      .title("Pipe Dream")
      .description("Defeating that guardian was a pain, but now it pays dividends")
      .after(MANADUCT_TIER_3)
      .special(NOISY)
      .whenIconCollected()),
    MANA_CONDENSER = create("mana_condenser", b -> b.icon(zaftnotameni.creatania.registry.Blocks.MANA_CONDENSER.get())
      .title("Mana ex nihilo")
      .description("You're now ready to extract mana out of thin air, though it might be corrupted in the process")
      .after(MANA_MACHINE_COMPONENT)
      .special(NOISY)
      .whenIconCollected()),
    MANA_MOTOR = create("mana_motor", b -> b.icon(zaftnotameni.creatania.registry.Blocks.MANA_MOTOR.get())
      .title("Don't Stress over it... you'll MANAge just fine")
      .description("You're now ready to generate rotation force with mana")
      .after(MANA_MACHINE_COMPONENT)
      .whenIconCollected()),

  // melting
    MOLTEN_BRASS_FLUID = melt(Fluids.MOLTEN_BRASS, "Bucket of Molten Brass"),
    MOLTEN_GAIA = melt(Fluids.MOLTEN_GAIA,"Bucket of Molten Gaia"),
    MOLTEN_ELEMENTIUM = melt(Fluids.MOLTEN_ELEMENTIUM,"Bucket of Molten Elementium"),
    MOLTEN_MANASTEEL = melt(Fluids.MOLTEN_MANASTEEL,"Bucket of Molten Manasteel"),
    MOLTEN_TERRASTEEL = melt(Fluids.MOLTEN_TERRASTEEL,"Bucket of Molten Terrasteel"),
    MOLTEN_ANDESITE = melt(Fluids.MOLTEN_ANDESITE,"Bucket of Molten Andesite"),
    MOLTEN_COPPER_FLUID = melt(Fluids.MOLTEN_COPPER,"Bucket of Molten Copper"),
    MOLTEN_GOLD_FLUID = melt(Fluids.MOLTEN_GOLD,"Bucket of Molten Gold"),
    MOLTEN_IRON_FLUID = melt(Fluids.MOLTEN_IRON,"Bucket of Molten Iron"),
    MOLTEN_ZINC_FLUID = melt(Fluids.MOLTEN_ZINC,"Bucket of Molten Zinc"),
    BOTANIA_MANA_FLUID = melt(Fluids.REAL_MANA,"Bucket of Real Mana"),
    CORRUPT_MANA_FLUID = melt(Fluids.CORRUPT_MANA,"Bucket of Corrupt Mana"),
    PURIFIED_MANA_FLUID = melt(Fluids.PURE_MANA,"Bucket of Pure Mana"),

  // botanical contraptions

  // secrets
    DOING_THE_LORDS_WORK = create("lords_work", b -> b.icon(net.minecraft.world.item.Items.WANDERING_TRADER_SPAWN_EGG)
      .title("More like wandering TRAITOR...")
      .description("The llame llama lloser got what he deserves, thanks for your service")
      .after(ROOT)
      .special(SECRET)),
    BUFF_FROM_INERT_MANA_BLOCKS = create("buff_from_purified_blocks", b -> b.icon(Blocks.PURE_MANA_BLOCK.get())
      .title("Power Overwhelming!")
      .description("Purified mana might be inert, but still contains a lot of power within")
      .after(ROOT)
      .special(SECRET)),
    BUFF_FROM_REAL_MANA_BLOCKS = create("buff_from_real_mana_blocks", b -> b.icon(Blocks.REAL_MANA_BLOCK.get())
      .title("Flying High")
      .description("Botania mana blocks are the real deal, real condensed magical power")
      .after(ROOT)
      .special(SECRET)),
    DEBUFF_FROM_INERT_MANA_BLOCKS = create("debuff_from_corrupt_blocks", b -> b.icon(Blocks.CORRUPT_MANA_BLOCK.get())
      .title("Watch your step!")
      .description("Corrupt mana might be inert, but still extremely dangerous")
      .after(ROOT)
      .special(SECRET)),
    PICK_A_BOTANIA_BLOCK_WITH_CREATE_WRENCH = create("botania_block_with_create_wrench", b -> b.icon(AllItems.WRENCH.get())
      .title("Joyful Mana Gut Wrenching")
      .description("Pick up blocks from botania using the create wrench. Be very careful with it")
      .after(ROOT)
      .special(SECRET)),
    PREVENT_ENDER_ENTITY_FROM_TELEPORTING = create("prevent_ender_entity_from_teleporting", b -> b.icon(net.minecraft.world.item.Items.ENDER_PEARL)
      .title("Denied!")
      .description("Corrupt mana blocks, among its many properties, can prevent ender entities from teleporting")
      .after(ROOT)
      .special(SECRET)),
    PRODUCE_MANA_GEL_FROM_SLIME = create("produce_mana_gel_from_slime", b -> b.icon(Items.MANA_GEL.get())
      .title("YUMMY!")
      .description("Produce mana gel by having a slime be hurt while touching pure mana")
      .after(ROOT)
      .special(SECRET)),
    END = null;

  public static CreataniaAdvancement create(String id, UnaryOperator<CreataniaAdvancement.Builder> b) {
    return new CreataniaAdvancement(id, b);
  }

  public static CreataniaAdvancement melt(FluidEntry<ForgeFlowingFluid.Flowing> fe, String description) {
    return create("your_first_" + fe.getId().getPath(), b -> b.icon(fe.get().getBucket())
      .title(Humanity.digestItem(fe.get().getBucket()))
      .description("Grabbing a " + description + " from a hot mixer")
      .after(ROOT));
  }
  public static void register() {}
}