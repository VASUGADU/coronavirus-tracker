package io.vasupractice.coronavirustracker.models;

import java.util.Objects;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationStats stats = (LocationStats) o;
        return latestTotalCases == stats.latestTotalCases &&
                Objects.equals(state, stats.state) &&
                Objects.equals(country, stats.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, country, latestTotalCases);
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
