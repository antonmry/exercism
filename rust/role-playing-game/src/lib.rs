pub struct Player {
    pub health: u32,
    pub mana: Option<u32>,
    pub level: u32,
}

impl Player {
    // Revive this player
    pub fn revive(&self) -> Option<Player> {
        if self.health != 0 {
            return None;
        }

        if self.level >= 10 {
            return Some(Player {
                health: 100,
                mana: Some(100),
                level: self.level,
            });
        } else {
            return Some(Player {
                health: 100,
                mana: None,
                level: self.level,
            });
        }
    }

    // Cast a spell of cost mana_cost
    pub fn cast_spell(&mut self, mana_cost: u32) -> u32 {
        if self.mana.is_none() {
            self.health = if self.health < mana_cost {
                0
            } else {
                self.health - mana_cost
            };
            return 0;
        }

        if self.mana.unwrap() < mana_cost {
            return 0;
        };

        self.mana = Some(self.mana.unwrap() - mana_cost);
        return 2 * mana_cost;
    }
}
