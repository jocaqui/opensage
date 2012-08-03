#============================================================================
# File:      sim_params.py
#                                                                          
# Author:    Dan Baechle
#                                                                          
# History:   Created 4/30/5
#                                                                          
# Notes:     Configuration file for simulation program which samples a 
#            population of haplotypes w. the given frequencies and produces
#            a set of unrelated individuals.  Recombination is assumed to be 0.
#
#============================================================================

ind_count = 1000
fraction_missing_data = 0

# - haps[x][0] = haplotype frequency.
#   haps[x][1] = list of alleles defining the haplotype.
#   constraints
#     + haplotype frequencies must sum to 1.
#     + haplotypes must be of the same length.
#
haps = [ [.120, ['1', '1', '1']],
         [.120, ['1', '1', '2']],
         [.120, ['1', '2', '1']],
         [.120, ['1', '2', '2']],
         [.130, ['2', '1', '1']],
         [.130, ['2', '1', '2']],
         [.130, ['2', '2', '1']],
         [.130, ['2', '2', '2']], ]