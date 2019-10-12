import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProteinTranslator {

    private final static HashMap<String, Boolean> stopSeqs = new HashMap<>();

    static {
        stopSeqs.put("UAA", true);
        stopSeqs.put("UAG", true);
        stopSeqs.put("UGA", true);
    }

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < rnaSequence.length(); i = i + 3) {
            if (isStopSeq(rnaSequence.substring(i, i + 3))) break;
            result.add(NormalSeq.valueOf(rnaSequence.substring(i, i + 3)).translate());
        }

        return result;

    }

    private boolean isStopSeq(String s) {
        return stopSeqs.getOrDefault(s.toUpperCase(), false);
    }

    // This should be a HashMap, just for fun
    enum NormalSeq {

        AUG {
            @Override
            public String translate() {
                return "Methionine";
            }
        },
        UUU {
            @Override
            public String translate() {
                return "Phenylalanine";
            }
        },
        UUC {
            @Override
            public String translate() {
                return "Phenylalanine";
            }
        },
        UUA {
            @Override
            public String translate() {
                return "Leucine";
            }
        },
        UUG {
            @Override
            public String translate() {
                return "Leucine";
            }
        },
        UCU {
            @Override
            public String translate() {
                return "Serine";
            }
        },
        UCC {
            @Override
            public String translate() {
                return "Serine";
            }
        },
        UCA {
            @Override
            public String translate() {
                return "Serine";
            }
        },
        UCG {
            @Override
            public String translate() {
                return "Serine";
            }
        },
        UAU {
            @Override
            public String translate() {
                return "Tyrosine";
            }
        },
        UAC {
            @Override
            public String translate() {
                return "Tyrosine";
            }
        },
        UGU {
            @Override
            public String translate() {
                return "Cysteine";
            }
        },
        UGC {
            @Override
            public String translate() {
                return "Cysteine";
            }
        },
        UGG {
            @Override
            public String translate() {
                return "Tryptophan";
            }
        },
        ;

        public abstract String translate();

    }
}