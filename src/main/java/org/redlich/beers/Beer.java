/*
 * Craft Beer Database Application
 * This demo application is featured in the `Getting Started with Jakarta NoSQL and MongoDB presentation`
 *
 * @author Otávio Santana
 * @author Michael P. Redlich
 *
 * @version 1.0.5
 */

package org.redlich.beers;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

@Entity
public class Beer {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private BeerType type;

    @Column("brewer_id")
    private int brewerId;

    @Column
    private double abv;

    public Beer() {
        id = 0;
        name = "{ beer name }";
        type = BeerType.ALE;
        brewerId = 0;
        abv = 10.0;
        }

    private Beer(int id, String name, BeerType type, int brewerId, double abv) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brewerId = brewerId;
        this.abv = abv;
        }

    /**
     * public int getId()
     * @return id of the Beer entity.
     */
    public int getId() {
        return id;
        }

    /**
     * public String getName()
     * @return the name of the beer.
     */
    public String getName() {
        return name;
        }

    /**
     *
     * @return the beer type.
     */
    public BeerType getType() {
        return type;
        }

    /**
     *
     * @return the value of `brewerId` from the Brewer entity.
     */
    public int getBrewerId() {
        return brewerId;
        }

    /**
     *
     * @return the value of `abv`.
     */
    public double getAbv() {
        return abv;
        }

    @Override
    public String toString() {
        return "Beer { " +
                "id = '" + getId() + '\'' +
                ", name = '" + getName() + '\'' +
                ", type = '" + getType() + '\'' +
                ", brewer_id = '" + getBrewerId() + '\'' +
                ", abv = '" + getAbv() + '\'' +
                " }\n";
        }

    public static BeerBuilder builder() {
        return new BeerBuilder();
        }

    public static class BeerBuilder {
        private int id;
        private String name;
        private BeerType type;
        private int brewer_id;
        private double abv;

        private BeerBuilder() {
            }

        public BeerBuilder id(int id) {
            this.id = id;
            return this;
            }

        public BeerBuilder name(String name) {
            this.name = name;
            return this;
            }

        public BeerBuilder type(BeerType type) {
            this.type = type;
            return this;
            }

        public BeerBuilder brewer_id(int brewer_id) {
            this.brewer_id = brewer_id;
            return this;
            }

        public BeerBuilder abv(double abv) {
            this.abv = abv;
            return this;
            }

        public Beer build() {
            return new Beer(id, name, type, brewer_id, abv);
            }
        }
    }
