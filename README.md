# USAGES


**Create Axe Object**
```java
// All custom objects & methods in AxesAPI class
// So do AxesAPI. before every method or object

HashMap<Enchantment , Integer> enchants = new HashMap<Enchantment,Integer>();
enchants.put(Enchantment.DAMAGE_ALL, 1);
enchants.put(Enchantment.DURABILITY, 3);

List<String> lore = Arrays.asList("", "&cLOCKED");
Axe axe = new Axe(enchants, lore, "&aAXE");
              
ItemStack axItemStack = createAxeItemStack(axe);
```

# EVENTS

```java
@EventHandler
public void DropLockedItemEvent(DropLockedItemEvent e){

    // Set what should lore contain to continue event with
    e.setLockedString("&cLOCKED");

    // Get what should lore contain to continue event with
    e.getLockedString();
        
    // Get if event cancelled or no
     e.isCancelled();

    // To cancell dropping the locked item from death or normal drop
    e.setCancelled(true);
        
}
```

```java
@EventHandler
public void DropLockedItemEvent(PlayerDamagePlayerWithAxeEvent e){

        // Get Axe Object
        e.getAxe();

        // AXE OBJECT USAGES

                // Get axe name
                 e.getAxe().getName();

                // Get axe lore
                e.getAxe().getLore();

                // Get axe enchants
                e.getAxe().getEnchants();

        // Get who got damaged
        e.getVictim();

        // Get Damager
        e.getDamager();
        
        // Get if event cancelled or no
        e.isCancelled();

        // Cancell damage event
        e.setCancelled(true);

}
```

