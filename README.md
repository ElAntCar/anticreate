# AntiCreate

A personal NeoForge 1.21.1 mod: adds a firework rocket item
(`anticreate:brass_rocket`) with a **fixed power 3** and a custom
recipe using Create brass. Built for use on a private server —
no mixins, no custom entity, just vanilla firework rocket behavior
under a new item ID.

## What it does

- New item `anticreate:brass_rocket`, with its own texture and model.
- When used while gliding with an elytra, it always gives a
  **power 3** boost (no color stars).
- Crafted with a shapeless crafting-table recipe — and being
  shapeless, it's also automatable in Create's **Mechanical Crafter**
  ("Automated Shapeless Crafting").

## Requirements

- Minecraft 1.21.1
- NeoForge `21.1.234` (or compatible)
- Create 6.0+ (for the `create:brass_ingot` recipe ingredient)

## Recipe

Shapeless, in a crafting table (or Mechanical Crafter):

| Ingredient | Amount |
|---|---|
| `create:brass_ingot` | 1 |
| `minecraft:paper` | 1 |
| `minecraft:gunpowder` | 1 |

Result: 3× `anticreate:brass_rocket`

Adjustable in `data/anticreate/recipe/brass_rocket.json` (e.g. switch
to `create:brass_nugget` for a finer-grained cost).


## Credits / origin

The "brass rocket" concept (fixed power + custom texture) is inspired
by the **Creatia 3** mod by CrossFace22 (MIT license). This is a
minimal from-scratch reimplementation: it doesn't reuse their code,
entity, or renderer — just the item name and idea.

## License

MIT