# USAGES
```java
        HashMap<Enchantment , Integer> enchants = new HashMap<Enchantment,Integer>();
        enchants.put(Enchantment.DAMAGE_ALL, 1);
        enchants.put(Enchantment.DURABILITY, 3);

        List<String> lore = Arrays.asList("", "&cLOCKED");
        Axe axe = new Axe(enchants, lore, "&aAXE");
              
        ItemStack axItemStack = createAxeItemStack(axe);
```
