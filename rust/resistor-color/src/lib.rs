use int_enum::IntEnum;

#[repr(u32)]
#[derive(Copy, Clone, Debug, PartialEq, Eq, IntEnum)]
pub enum ResistorColor {
    Black = 0,
    Blue = 6,
    Brown = 1,
    Green = 5,
    Grey = 8,
    Orange = 3,
    Red = 2,
    Violet = 7,
    White = 9,
    Yellow = 4,
}

const ERROR_MESSAGE: &str = "value out of range";

pub fn color_to_value(_color: ResistorColor) -> u32 {
    _color.int_value()
}

pub fn value_to_color_string(value: u32) -> String {
    ResistorColor::from_int(value).map_or(ERROR_MESSAGE.to_string(), |s| format!("{:?}", s))
}

pub fn colors() -> Vec<ResistorColor> {
    unimplemented!("return a list of all the colors ordered by resistance")
}
