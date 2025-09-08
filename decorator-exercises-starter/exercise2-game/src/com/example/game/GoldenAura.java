package com.example.game;

public class GoldenAura extends CharacterDecorator {

    public GoldenAura(Character character) {
        super(character);
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + 2; // Small speed buff
    }

    @Override
    public int getDamage() {
        return character.getDamage() + 3; // Small damage buff
    }

    @Override
    public String getSprite() {
        return "golden_" + character.getSprite(); // Changes sprite
    }
}
