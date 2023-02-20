package zaftnotameni.creatania.registry;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class CreataniaRegistryEntry<T extends IForgeRegistryEntry<? super T>> extends RegistryEntry<T> {
  public CreataniaRegistryEntry(AbstractRegistrate<?> owner, RegistryObject<T> delegate) {
    super(owner, delegate);
  }
}
