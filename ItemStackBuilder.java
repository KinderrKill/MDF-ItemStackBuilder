import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemStackBuilder {

    private final Material material;
    private int amount = 1;
    private short data = 0;
    private String name;
    private List<String> lore;

    public ItemStackBuilder(Material material) {
        this.material = material;
    }

    public ItemStackBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemStackBuilder setData(int data) {
        this.data = (short) data;
        return this;
    }

    public ItemStackBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemStackBuilder setLore(String... lore) {
        this.lore = Arrays.asList(lore);
        return this;
    }

    public ItemStack buildItem() {
        ItemStack stack = data != 0 ? new ItemStack(material, amount, data) : new ItemStack(material, amount);
        ItemMeta meta = stack.getItemMeta();
        if(name != null) meta.setDisplayName(name);
        if(lore != null && !lore.isEmpty()) meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }
}
