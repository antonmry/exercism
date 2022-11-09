use std::cmp::min;

pub struct Player {
    pub health: u32,
    pub mana: Option<u32>,
    pub level: u32,
}

impl Player {
    // Revive this player
    pub fn revive(&self) -> Option<Player> {
        match self.health {
            0 => Some(Player {
                health: 100,
                mana: if self.level >= 10 { Some(100) } else { None },
                level: self.level,
            }),
            _ => None,
        }
    }

    // Cast a spell of cost mana_cost
    pub fn cast_spell(&mut self, mana_cost: u32) -> u32 {
        if self.mana.is_none() {
            self.health = self.health - min(self.health, mana_cost);
            return 0;
        }

        if self.mana.unwrap() < mana_cost {
            return 0;
        };

        self.mana = Some(self.mana.unwrap() - mana_cost);
        return 2 * mana_cost;
    }
}
