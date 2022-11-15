pub fn is_armstrong_number(num: u32) -> bool {
    let num_len = num.to_string().chars().count() as u32;
    num.to_string()
        .chars()
        .map(|c| c.to_digit(10).unwrap().pow(num_len))
        .sum::<u32>()
        == num
}
