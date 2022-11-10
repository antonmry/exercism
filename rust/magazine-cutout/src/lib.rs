use std::collections::HashMap;

//fn calculate_occurrences(text: &[&str]) -> HashMap<&str, i32> {
//    text.iter().fold(HashMap::new(), |mut map, c| {
//        *map.entry(c).or_insert(0) += 1;
//        map
//    })
//}

pub fn can_construct_note(magazine: &[&str], note: &[&str]) -> bool {
    let magazine_counts: HashMap<&str, i32> = magazine.iter().fold(HashMap::new(), |mut map, c| {
        *map.entry(c).or_insert(0) += 1;
        map
    });

    let note_counts: HashMap<&str, i32> = note.iter().fold(HashMap::new(), |mut map, c| {
        *map.entry(c).or_insert(0) += 1;
        map
    });

    note_counts
        .iter()
        .all(|e| magazine_counts.get(e.0).unwrap_or(&0) >= e.1)
}
