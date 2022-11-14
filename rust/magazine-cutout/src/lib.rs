use std::collections::HashMap;

fn calculate_occurrences<'a>(text: &[&'a str]) -> HashMap<&'a str, i32> {
    text.iter().fold(HashMap::new(), |mut map, c| {
        *map.entry(c).or_insert(0) += 1;
        map
    })
}

pub fn can_construct_note(magazine: &[&str], note: &[&str]) -> bool {
    let magazine_counts = calculate_occurrences(magazine);

    calculate_occurrences(note)
        .iter()
        .all(|e| magazine_counts.get(e.0).unwrap_or(&0) >= e.1)
}
