// Calculate hourly production rate at speed
pub fn production_rate_per_hour(speed: u8) -> f64 {
    match speed {
        0 => 0.0,
        1..=4 => speed as f64 * 221.0 * 1.0,
        5..=8 => speed as f64 * 221.0 * 0.9,
        9..=10 => speed as f64 * 221.0 * 0.77,
        _ => panic!("Speed not supported"),
    }
}

// Calculate the amount of working items at speed
pub fn working_items_per_minute(speed: u8) -> u32 {
    (production_rate_per_hour(speed) / 60.0) as u32
}
