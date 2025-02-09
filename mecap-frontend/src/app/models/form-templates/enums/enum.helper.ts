export function getEnumKeyByValue<T extends Record<string, string | number>>(
  enumObj: T,
  value: string | number
): string | undefined {
  return Object.keys(enumObj).find((key) => enumObj[key as keyof T] === value);
}
export function getEnumValueByKey<T extends Record<string, string>>(enumObj: T, key: string): string | undefined {
  return enumObj[key as keyof T]; // Correctly looks up the value by key
}