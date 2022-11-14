#[derive(Debug)]
pub enum CalculatorInput {
    Add,
    Subtract,
    Multiply,
    Divide,
    Value(i32),
}

// Example
pub fn evaluate(inputs: &[CalculatorInput]) -> Option<i32> {
    let mut stack: Vec<i32> = Vec::new();

    for input in inputs {
        let stack_entry = match input {
            CalculatorInput::Add if stack.len() >= 2 => stack.pop().unwrap() + stack.pop().unwrap(),
            CalculatorInput::Subtract if stack.len() >= 2 => {
                -1 * stack.pop().unwrap() + stack.pop().unwrap()
            }
            CalculatorInput::Multiply if stack.len() >= 2 => {
                stack.pop().unwrap() * stack.pop().unwrap()
            }
            CalculatorInput::Divide if stack.len() >= 2 => {
                let t = stack.pop().unwrap();
                stack.pop().unwrap() / t
            }
            CalculatorInput::Value(n) => *n,
            _ => return None,
        };

        stack.push(stack_entry);
    }

    match stack.len() {
        1 => stack.pop(),
        _ => None,
    }
}
