# UPLOAD FILE
*https://www.spigotmc.org/resources/axesapi.117473/*

![image](https://github.com/tempMahmoud/Axes-System/assets/170753064/f0481967-6ed1-48f4-b0ee-a0fd36023c00)

# PUT DEPENDENCY
```xml
<dependency>
  <groupId>org.m7moud</groupId>
  <artifactId>axes</artifactId>
  <version>1.0-SNAPSHOT</version>
  <scope>system</scope>
  <systemPath>${project.basedir}/lib/AxesAPI.jar</systemPath>
</dependency>
```
**And enjoy!**

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
public void PlayerDamageWithAxeEvent(PlayerDamagePlayerWithAxeEvent e){

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

