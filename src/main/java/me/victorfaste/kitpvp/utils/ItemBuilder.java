package me.victorfaste.kitpvp.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * @class 5 - (ItemBuilder orientado à objeto)
 * <p>
 * new ItemBuilder(Material)
 * .name("dwadawa")
 * .lore("1", "2")
 * .build() ---
 * X .name(nao pode);
 */
public class ItemBuilder {
    //variavel da class
    private ItemStack itemStack;
    private ItemMeta itemMeta;

    // Constructor da item
    public ItemBuilder(Material material) {
        // Inicializando variaveis locais da class
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder name(String name) {
        // Pegando a variavel local inicializada (itemMeta) e chamando um metodo dela (do objeto ItemMeta)
        this.itemMeta.setDisplayName(name);

        return this;
    }

    /**
     * String[] = lore(new String[]{"", ""})
     * String... = lore("", "", "")
     */
    public ItemBuilder lore(String... lore) {
        // Pegando a variavel local inicializada (itemMeta) e chamando um metodo dela (do objeto ItemMeta)
        this.itemMeta.setLore(Arrays.asList(lore));

        return this;
    }

    public ItemBuilder durability(short durability) {
        // Pegando a variavel local inicializada (iTEMSTACK) e chamando um metodo dela (do objeto ITEMSTACK)
        this.itemStack.setDurability(durability);

        return this;
    }

    public ItemBuilder durability(int durability) {
        // this ==> Referenciando a class iTEMBUILDER, assim chamando o metodo durability
        //
        return this.durability((short) durability);
    }

    public ItemBuilder amount(int amount) {
        // Pegando a variavel local inicializada (itemStack) e chamando um metodo dela (do objeto ItemStack)
        this.itemStack.setAmount(amount);

        return this;
    }

    public ItemStack build() {
        // Pegando a variavel local inicializada (itemStack) e chamando um metodo dela (do objeto ItemStack)
        this.itemStack.setItemMeta(this.itemMeta);

        return this.itemStack;
    }
}

